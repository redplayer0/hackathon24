package com.example.payments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Shop
 */
@Entity
@Data
@AllArgsConstructor
@Table(name = "SHOPS")
@NoArgsConstructor
@Builder
public class Shop extends AppUser {
  @Id
  private Integer vat;
  private String name;
  private String address;
  private String creationdate;
  private String deletiondate;
  private Double balance ;
  private String picture;
  private Integer userid;
}
