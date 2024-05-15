package com.example.payments.entities.dtos;

import lombok.Builder;
import lombok.Data;

/**
 * CustomerCreateDTO
 */
@Data
@Builder
public class CustomerLimitsBalanceDTO {
  private Long weeklytransfer;
  private Long weeklylimit;
  private Long balance;
}
