
package com.example.payments.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.payments.AuthService;
import com.example.payments.entities.Customer;
import com.example.payments.entities.User;
import com.example.payments.entities.dtos.CustomerCreateDTO;
import com.example.payments.entities.dtos.CustomerLimitsBalanceDTO;
import com.example.payments.services.CustomerService;

/**
 * CustomerController
 */
@RestController
public class CustomerController {
  @Autowired
  private CustomerService customerService;
  @Autowired
  private AuthService authService;

  // @GetMapping("customers/{customer}")
  // public Customer getCustomer(@PathVariable(value = "customer")) {

  // }

  @GetMapping("customer_balance")
  public CustomerLimitsBalanceDTO customerBalance(@RequestHeader("mycookie") String cookie) {
    Optional<User> possibleUser = authService.getUser(cookie);
    if (!possibleUser.isEmpty()) {
      return customerService.sendLimitsBalance(possibleUser.get().getId());
    }
    return null;
  }

  @PostMapping("create_customer")
  public String createCustomer(@RequestBody CustomerCreateDTO customerDTO) {
    return customerService.createCustomer(customerDTO);
  }
}
