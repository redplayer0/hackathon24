package com.example.payments.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payments.entities.PaypalIban;


/**
 * PaypalIbanRepository
 */
@Repository
public interface PaypalIbanRepository extends JpaRepository<PaypalIban, Integer> {
  public boolean existsByVat(Integer vat);
  public boolean existsByAccount(String account);
  public Optional<PaypalIban> findByVat(Integer vat);
}
