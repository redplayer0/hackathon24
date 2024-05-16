package com.example.payments.entities.dtos;

import lombok.Data;

/**
 * ShopCreateDTO
 */
@Data
public class ShopCreateDTO {
  private String email;
  private String password;
  private String role;
  private Integer vat;
  private String name;
  private String address;
  private String picture;
}
