package com.example.payments.entities.dtos;

import lombok.Data;

/**
 * CustomerCreateDTO
 */
@Data
public class CustomerCreateDTO {
  private Integer vat;
  private String firstname;
  private String lastname;
  private String birthday;
  private String birthaddress;
  private Long weeklytransfer;
  private Long weeklylimit;
}
