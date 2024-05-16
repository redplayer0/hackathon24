package com.example.payments.entities.dtos;

import lombok.Builder;
import lombok.Data;

/**
 * CustomerCreateDTO
 */
@Data
@Builder
public class CustomerLimitsBalanceDTO {
  private Double weeklytransfer;
  private Double weeklylimit;
  private Double balance;
}
