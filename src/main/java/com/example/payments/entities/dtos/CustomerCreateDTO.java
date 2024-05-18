package com.example.payments.entities.dtos;

import lombok.Data;

/**
 * CustomerCreateDTO
 */
@Data
public class CustomerCreateDTO {
  private String email;
  private String password;
  private String role;
  private Integer vat;
  private String firstname;
  private String lastname;
  private String birthday;
  private String birthaddress;
  private Double weeklytransfer;
  private Double weeklylimit;
}
