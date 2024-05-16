package com.example.payments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Provider
 */
@Entity
@Data
@AllArgsConstructor
@Table(name = "PROVIDER")
@NoArgsConstructor
public class Provider {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer vat;
  private String companyname;
  private String address;
  private Double balance;
}
