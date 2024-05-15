package com.example.payments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@Table(name = "SHOPS")
@NoArgsConstructor
@Builder
@Setter
@Getter
/**
 * Transaction
 */
public class Transaction {

  @Id
  private int transactionid;
  private String sourceibanpaypal;
  private String targetiban;
  private long amount;
  private String datetime;
}

