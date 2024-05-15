
package com.example.payments.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.payments.entities.ProviderTransaction;
import com.example.payments.entities.Transaction;
import com.example.payments.entities.User;
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
  private PaypalIbanRepository paypalIbanRepository;
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

  @Transactional
  public String createProviderTransaction(Long amount, String customeraccount) {
    ProviderTransaction transaction = ProviderTransaction.builder()
        .customeraccount(customeraccount)
        .provideriban(providerIban)
        .amount(amount)
        .build();
    System.out.println(transaction.toString());
    providerTransactionRepository.save(transaction);
    return "transaction record created successfully.";
  }

  @Transactional
  public String createTransaction(TransactionCreateDTO transactionDto, Integer user_id) {
    Integer sourcevat = customerRepository.findByUserid(user_id).get().getVat();
    String sourceaccount = paypalIbanRepository.findByVat(sourcevat).get().getAccount();
    Integer shopvat = shopRepository.findByName(transactionDto.getShopname()).get().getVat();
    String targetaccount = paypalIbanRepository.findByVat(shopvat).get().getAccount();

    Transaction transaction = Transaction.builder()
        .sourceaccount(sourceaccount)
        .targetaccount(targetaccount)
        .amount(transactionDto.getAmount())
        .build();
    createProviderTransaction(transactionDto.getAmount(), sourceaccount);
    transactionRepository.save(transaction);
    return "transaction record created successfully.";
  }
}
