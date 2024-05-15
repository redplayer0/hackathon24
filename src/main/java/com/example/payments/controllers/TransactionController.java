package com.example.payments.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.payments.AuthService;
import com.example.payments.entities.User;
import com.example.payments.entities.dtos.TransactionCreateDTO;
import com.example.payments.services.TransactionService;

/**
 * TransactionController
 */
@RestController
public class TransactionController {
  @Autowired
  private TransactionService transactionService;
  @Autowired
  private AuthService authService;

  @Value("${PROVIDER_IBAN}")
  private String providerIban;


  @PostMapping("create_transaction")
  public String createPaypalIban(@RequestHeader("Cookie") String cookie, @RequestBody TransactionCreateDTO transactionDTO) {
    Optional<User> possibleUser = authService.getUser(cookie);
    if (!possibleUser.isEmpty()) {
      transactionService.createTransaction(transactionDTO, possibleUser.get().getId());
      transactionService.createTransaction(transactionDTO, possibleUser.get().getId());
      return "Successful";
    } else {
      return "An error occured";
    }
  }

	
}
