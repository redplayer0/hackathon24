package com.example.payments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Customer
 */
@Entity
@Data
@AllArgsConstructor
@Table(name = "CUSTOMERS")
@NoArgsConstructor
@Builder
public class Customer extends AppUser {
  @Id
  private Integer vat;
  private String firstname;
  private String lastname;
  private String birthday;
  private String birthaddress;
  private Double weeklytransfer;
  private Double weeklylimit;
  private Double balance;
  private String creationdate;
  private String deletiondate;
  private Integer userid;

}
