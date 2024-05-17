package com.example.payments.controllers;

import java.util.List;
import java.util.Optional;

import javax.print.event.PrintJobListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.payments.AuthService;
import com.example.payments.entities.Transaction;
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

  @GetMapping("transactions")
  public ResponseEntity<List<Transaction>> getTransactions(@RequestHeader("mycookie") String cookie) {
    Optional<User> possibleUser = authService.getUser(cookie);
    if (possibleUser.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(transactionService.getTransactions(possibleUser.get().getId()));
  }

  @PostMapping("create_transaction")
  public ResponseEntity<String> createTransaction(@RequestHeader("mycookie") String cookie,
      @RequestBody TransactionCreateDTO transactionDTO) {
    Optional<User> possibleUser = authService.getUser(cookie);
    if (!possibleUser.isEmpty()) {
      if (transactionService.createTransaction(transactionDTO, possibleUser.get().getId())) {
        return ResponseEntity.ok("Transaction created");
      } else {
        return new ResponseEntity<>("Cannot exceed weekly limit", HttpStatus.BAD_REQUEST);
      }
    } else {
      return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
    }
  }
}
