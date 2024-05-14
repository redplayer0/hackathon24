package com.example.payments.entities.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * UserLoginDTO
 */
@Data
@Getter
@Setter
public class UserLoginDTO {
  private String email;
  private String password;
}
