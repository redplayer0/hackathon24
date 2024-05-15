package com.example.payments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Transaction
 */
@Entity
@Data
@AllArgsConstructor
@Table(name = "TRANSACTIONS")
@NoArgsConstructor
@Builder
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer transactionid;
  private String sourceaccount;
  private String targetaccount;
  private Long amount;
  private String datetime;
}

