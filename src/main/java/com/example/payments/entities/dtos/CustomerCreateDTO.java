package com.example.payments.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * CustomerCreateDTO
 */
@Data
@Getter
@Setter
@AllArgsConstructor
public class CustomerCreateDTO {
  private Integer vat;
  private String firstname;
  private String lastname;
  private String birthday;
  private String birthaddress;
  private Long weeklytransfer;
  private Long weeklylimit;
}
