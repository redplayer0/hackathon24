package com.example.payments.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.payments.AuthService;
import com.example.payments.entities.AppUser;
import com.example.payments.entities.Customer;
import com.example.payments.entities.User;
import com.example.payments.repositories.CustomerRepository;
import com.example.payments.repositories.UserRepository;

/**
 * DashboardController
 */
@RestController
public class DashboardController {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private AuthService authService;

  @GetMapping("dashboard")
  public AppUser getCustomer(@RequestHeader("Cookie") String cookie) {
    Optional<User> possibleUser = authService.getUser(cookie);

    // if (!possibleUser.isEmpty()) {
    User user = possibleUser.get();
    String role = user.getRole();
    // if (role == "customer") {
    // Optional<Customer> optCustomer =
    // customerRepository.findByUserId(user.getId());
    // if (!optCustomer.isEmpty()) {
    // return optCustomer.get();
    // }
    // }
    Optional<Customer> optCustomer = customerRepository.findByUserid(user.getId());
    return optCustomer.get();
  }
}
