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

@Entity
@Data
@AllArgsConstructor
@Table(name = "SHOPS")
@NoArgsConstructor
@Builder
@Setter
@Getter
/**
 * Shop
 */
public class Shop {
  @Id
  private int vat;
  private String name;
  private String address;
  private String creationdate;
  private String deletiondate;
  private long balance ;
  private int userid;
	
}
