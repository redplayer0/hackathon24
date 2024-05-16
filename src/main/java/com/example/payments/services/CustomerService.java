package com.example.payments.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payments.entities.Customer;
import com.example.payments.entities.dtos.CustomerCreateDTO;
import com.example.payments.entities.dtos.CustomerLimitsBalanceDTO;
import com.example.payments.repositories.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository customerRepository;

  public boolean existsByVat(Integer vat) {
    return customerRepository.existsByVat(vat);
  }

  public void modifyBalance(Customer customer, Double amount) {
    customer.setBalance(customer.getBalance() + amount);
    customerRepository.save(customer);
  }

  public CustomerLimitsBalanceDTO sendLimitsBalance(Integer user_id) {
    Optional<Customer> possibleCustomer = customerRepository.findByUserid(user_id);
    if (!possibleCustomer.isEmpty()) {
      Customer customer = possibleCustomer.get();
      CustomerLimitsBalanceDTO response = CustomerLimitsBalanceDTO.builder()
        .balance(customer.getBalance())
        .weeklylimit(customer.getWeeklylimit())
        .weeklytransfer(customer.getWeeklytransfer())
        .build();
      return response;
    }
    return null;
  }

  @Transactional
  public String createCustomer(CustomerCreateDTO customerDto, Integer user_id) {
    System.out.println("CHECK CUSTOMER DTO");
    System.out.println(customerDto.toString());
    if (!customerRepository.existsByVat(customerDto.getVat())) {
      Customer customer = Customer.builder()
          .vat(customerDto.getVat())
          .firstname(customerDto.getFirstname())
          .lastname(customerDto.getLastname())
          .birthday(customerDto.getBirthday())
          .birthaddress(customerDto.getBirthaddress())
          .weeklytransfer(customerDto.getWeeklytransfer())
          .weeklylimit(customerDto.getWeeklylimit())
          .creationdate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
          .balance(0.0)
          .userid(user_id)
          .build();
      System.out.println(customer.toString());
      customerRepository.save(customer);
      return "Customer record created successfully.";
    } else {
      return "Customer already exists in the database.";
    }
  }
}
