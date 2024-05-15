package com.example.payments.entities.dtos;

import lombok.Data;

/**
 * ShopCreateDTO
 */
@Data
public class ShopCreateDTO {
  private Integer vat;
  private String name;
  private String address;
  private String picture;

}
