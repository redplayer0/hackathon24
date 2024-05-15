package com.example.payments.entities.dtos;

import lombok.Data;

/**
 * PaypalIbanCreateDTO
 */
@Data
public class PaypalIbanCreateDTO {
  private String account;
  private String ispaypal;
  private String bankname;
}
