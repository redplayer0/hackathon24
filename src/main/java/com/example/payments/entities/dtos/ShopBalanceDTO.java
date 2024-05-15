package com.example.payments.entities.dtos;

import lombok.Data;
import lombok.Builder;

/**
 * ShopBalanceDTO
 */
@Data
@Builder
public class ShopBalanceDTO {
  private Long balance;
}
