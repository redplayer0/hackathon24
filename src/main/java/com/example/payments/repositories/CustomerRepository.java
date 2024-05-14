package com.example.payments.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payments.entities.Customer;

/**
 * UserRepository
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  public boolean existsByVat(Integer vat);
  public Optional<Customer> findByVat(Integer vat);
  public Optional<Customer> findByUserId(Integer userId);
}

