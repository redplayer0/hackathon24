package com.example.payments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User
 */
@Entity
@Data
@AllArgsConstructor
@Table(name = "CUSTOMERS")
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Customer {
  @Id
  private Integer vat;
  private String firstName;
  private String lastName;
  private String birthday;
  private String birthAddress;
  private Long weeklyTranfer;
  private Long weeklyLimit;
  private Long balance;
  private String creationDate;
  private String deletionDate;
  private Integer userId;
}
