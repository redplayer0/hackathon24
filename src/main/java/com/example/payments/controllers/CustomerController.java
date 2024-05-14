
package com.example.payments.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.payments.services.CustomerService;

/**
 * CustomerController
 */
@RestController
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  // @GetMapping("customers/{customer}")
  // public Customer getCustomer(@PathVariable(value = "customer")) {
    
  // }
  @GetMapping("customer")
  public String getCustomerInfo() {
    return "HI";
  }
}
