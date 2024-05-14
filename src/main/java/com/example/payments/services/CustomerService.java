package com.example.payments.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payments.entities.Customer;
import com.example.payments.repositories.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository customerRepository;

  public boolean existsByVat(Integer vat) {
    return customerRepository.existsByVat(vat);
  }

  @Transactional
  public String createUser(Customer customer) {
    if (!customerRepository.existsByEmail(customer.getVat())) {
      customerRepository.save(customer);
      return "Customer record created successfully.";
    } else {
      return "Customer already exists in the database.";
    }
  }
}
