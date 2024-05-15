package com.example.payments.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payments.entities.Transaction;

/**
 * TransactionRepository
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
  public List<Transaction> findAllBySourceaccount(String sourceaccount);

  public List<Transaction> findAllByTargetaccount(String targetaccount);

  public List<Transaction> findAllBySourceaccountAndTargetaccount(String sourceaccount, String targetaccountn);
}
