
package com.example.payments.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.payments.entities.ProviderTransaction;
import com.example.payments.entities.User;
import com.example.payments.repositories.CustomerRepository;
import com.example.payments.repositories.PaypalIbanRepository;
import com.example.payments.repositories.ShopRepository;
import com.example.payments.repositories.ProviderTransactionRepository;

import jakarta.transaction.Transactional;

/**
 * ProviderTransactionService
 */
@Service
public class ProviderTransactionService {
  @Autowired
  private ProviderTransactionRepository providerTransactionRepository;

  @Value("${PROVIDER_IBAN}")
  private String providerIban;

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
}
