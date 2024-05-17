
package com.example.payments.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.payments.entities.Customer;
import com.example.payments.entities.PaypalIban;
import com.example.payments.entities.ProviderTransaction;
import com.example.payments.entities.Shop;
import com.example.payments.entities.Transaction;
import com.example.payments.entities.dtos.TransactionCreateDTO;
import com.example.payments.repositories.CustomerRepository;
import com.example.payments.repositories.PaypalIbanRepository;
import com.example.payments.repositories.ProviderTransactionRepository;
import com.example.payments.repositories.ShopRepository;
import com.example.payments.repositories.TransactionRepository;

import jakarta.transaction.Transactional;

/**
 * TransactionService
 */
@Service
public class TransactionService {
  @Autowired
  private TransactionRepository transactionRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private ShopRepository shopRepository;
  @Autowired
  private ShopService shopService;
  @Autowired
  private CustomerService customerService;
  @Autowired
  private PaypalIbanRepository paypalIbanRepository;
  @Autowired
  private ProviderService providerService;
  @Autowired
  private ProviderTransactionRepository providerTransactionRepository;

  @Value("${PROVIDER_IBAN}")
  private String providerIban;

  public List<Transaction> findAllBySourceaccount(String sourceaccount) {
    return transactionRepository.findAllBySourceaccount(sourceaccount);
  }

  public List<Transaction> findAllByTargetaccount(String targetaccount) {
    return transactionRepository.findAllByTargetaccount(targetaccount);
  }

  public List<Transaction> findAllBySourceaccountAndTargetaccount(String sourceaccount, String targetaccount) {
    return transactionRepository.findAllBySourceaccountAndTargetaccount(sourceaccount, targetaccount);
  }

  public List<ProviderTransaction> findAllByCustomeraccount(String customeraccount) {
    return providerTransactionRepository.findAllByCustomeraccount(customeraccount);
  }

  public List<Transaction> getTransactions(Integer user_id) {
    Integer vat;
    if (customerRepository.existsByUserid(user_id)) {
      vat = customerRepository.findByUserid(user_id).get().getVat();
    } else {
      vat = shopRepository.findByUserid(user_id).get().getVat();
    }
    String account = paypalIbanRepository.findByVat(vat).get().getAccount();
    return transactionRepository.findAllBySourceaccountOrTargetaccount(account, account);
  }

  // Here is the business logic for the first background process
  public void processPendingTransactions() {
    List<Transaction> transactions = transactionRepository.findAllByStatusIs("pending");
    Double amountForProviderBalance = 0.0;
    Double amountForCustomer = 0.0;

    for (Transaction transaction : transactions) {
      Optional<ProviderTransaction> optionalProTrans = providerTransactionRepository
          .findById(transaction.getTransactionid());
      if (!optionalProTrans.isEmpty()) {
        ProviderTransaction providerTransaction = optionalProTrans.get();
        amountForProviderBalance += providerTransaction.getAmount();
        if (transaction.getAmount() > 5) {
          amountForProviderBalance += 0.5;
        }
        transaction.setStatus("recieved");
        transactionRepository.save(transaction);
      }
    }
    providerService.modifyBalance(amountForProviderBalance);
  }

  public void processRecievedTransactions() {
    List<Transaction> transactions = transactionRepository.findAllByStatusIs("recieved");
    List<Shop> shops = shopRepository.findAll();
    Double amountForShop;
    for (Shop shop : shops) {
      amountForShop = 0.0;
      String shopaccount = paypalIbanRepository.findByVat(shop.getVat()).get().getAccount();
      for (Transaction transaction : transactions) {
        if (transaction.getTargetaccount().equals(shopaccount)) {
          if (transaction.getStatus().equals("recieved")) {
            amountForShop += transaction.getAmount();
            transaction.setStatus("sent");
            transactionRepository.save(transaction);
          }
        }
        shopService.modifyBalance(shop, amountForShop);
        providerService.modifyBalance(-amountForShop);
      }
    }
  }

  @Transactional
  public String createProviderTransaction(Double amount, String customeraccount, Integer transactionid) {
    ProviderTransaction transaction = ProviderTransaction.builder()
        .transactionid(transactionid)
        .customeraccount(customeraccount)
        .provideriban(providerIban)
        .amount(amount)
        .datetime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        .build();
    System.out.println(transaction.toString());
    providerTransactionRepository.save(transaction);
    return "transaction record created successfully.";
  }

  @Transactional
  public boolean createTransaction(TransactionCreateDTO transactionDto, Integer user_id) {
    Customer customer = customerRepository.findByUserid(user_id).get();
    Integer sourcevat = customerRepository.findByUserid(user_id).get().getVat();
    Double weeklylimit = customerRepository.findByUserid(user_id).get().getWeeklylimit();
    Double customerBalance = customerRepository.findByUserid(user_id).get().getBalance();
    String sourceaccount = paypalIbanRepository.findByVat(sourcevat).get().getAccount();
    Integer shopvat = shopRepository.findByName(transactionDto.getShopname()).get().getVat();
    String targetaccount = paypalIbanRepository.findByVat(shopvat).get().getAccount();

    Transaction transaction = Transaction.builder()
        .sourceaccount(sourceaccount)
        .targetaccount(targetaccount)
        .amount(transactionDto.getAmount())
        .status("pending")
        .datetime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        .build();

    Double currentExpenses = 0.0;
    for (Transaction pendingTransaction : transactionRepository.findAllByStatusIsAndSourceaccountIs("pending",
        sourceaccount)) {
      currentExpenses += pendingTransaction.getAmount();
    }
    if (weeklylimit >= currentExpenses + transactionDto.getAmount() + customerBalance) {
      transactionRepository.save(transaction);
      createProviderTransaction(transactionDto.getAmount(), sourceaccount, transaction.getTransactionid());
      if (transactionDto.getAmount() > 5) {
        customerService.modifyBalance(customer, 0.5);
      }
      return true;
    }
    return false;
  }
}
