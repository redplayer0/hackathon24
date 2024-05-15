package com.example.payments.entities.dtos;

import lombok.Data;

/**
 * TransactionCreateDTO
 */
@Data
public class TransactionCreateDTO {
  private String shopname;
  private long amount;
}
