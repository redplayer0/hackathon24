package com.example.payments.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payments.entities.ProviderTransaction;

/**
 * ProviderTransactionRepository
 */
@Repository
public interface ProviderTransactionRepository extends JpaRepository<ProviderTransaction, Integer>  {
  public List<ProviderTransaction> findAllByCustomeraccount(String customeraccount);
  public Optional<ProviderTransaction> findByTransactionid(Integer id);
}
