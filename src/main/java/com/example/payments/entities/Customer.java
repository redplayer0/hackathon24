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
public class Customer extends AppUser {
  @Id
  private Integer vat;
  private String firstname;
  private String lastname;
  private String birthday;
  private String birthaddress;
  private Long weeklytransfer;
  private Long weeklylimit;
  private Long balance;
  private String creationdate;
  private String deletiondate;
  private Integer userid;
}
