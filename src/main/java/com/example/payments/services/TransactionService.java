
package com.example.payments.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payments.entities.Transaction;
import com.example.payments.entities.User;
import com.example.payments.entities.dtos.TransactionCreateDTO;
import com.example.payments.repositories.CustomerRepository;
import com.example.payments.repositories.PaypalIbanRepository;
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

  public List<Transaction> findAllBySourceaccount(String sourceaccount) {
    return transactionRepository.findAllBySourceaccount(sourceaccount);
  }

  public List<Transaction> findAllByTargetaccount(String targetaccount) {
    return transactionRepository.findAllByTargetaccount(targetaccount);
  }

  public List<Transaction> findAllBySourceaccountAndTargetaccount(String sourceaccount, String targetaccount) {
    return transactionRepository.findAllBySourceaccountAndTargetaccount(sourceaccount, targetaccount);
  }

  @Transactional
  public String createTransaction(TransactionCreateDTO transactionDto, Integer user_id) {
    Integer sourcevat = customerRepository.findByUserid(user_id).get().getVat();
    String sourceaccount = paypalIbanRepository.findByVat(sourcevat).get().getAccount();
    Integer shopvat = shopRepository.findByName(transactionDto.getShopname()).get().getVat();
    String targetaccount = paypalIbanRepository.findByVat(shopvat).get().getAccount();

    System.out.println("CHECK transaction DTO");
    System.out.println(transactionDto.toString());
    Transaction transaction = Transaction.builder()
        .sourceaccount(sourceaccount)
        .targetaccount(targetaccount)
        .amount(transactionDto.getAmount())
        .build();
    System.out.println(transaction.toString());
    transactionRepository.save(transaction);
    return "transaction record created successfully.";
  }
}
