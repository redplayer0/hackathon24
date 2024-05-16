package com.example.payments.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payments.entities.Customer;
import com.example.payments.entities.User;
import com.example.payments.entities.dtos.CustomerCreateDTO;
import com.example.payments.entities.dtos.CustomerLimitsBalanceDTO;
import com.example.payments.repositories.CustomerRepository;
import com.example.payments.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserService userService;

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
  public String createCustomer(CustomerCreateDTO customerDto) {
    System.out.println("CHECK CUSTOMER DTO");
    System.out.println(customerDto.toString());
    if (customerRepository.existsByVat(customerDto.getVat())) {
      return "Customer already exists in the database.";
    }
    if (userRepository.existsByEmail(customerDto.getEmail())) {
      return "User already exists";
    }
    User user = User.builder()
      .email(customerDto.getEmail())
      .password(customerDto.getPassword())
      .role(customerDto.getRole())
      .build();
    userRepository.save(user);
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
      .userid(user.getId())
      .build();
    customerRepository.save(customer);
    return "Customer record created successfully.";
  }
}
