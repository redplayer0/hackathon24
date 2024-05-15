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
 * PaypalIban
 */
public class PaypalIban {
  @Id
  private String iban;
  private int vat ;
  private String startdate;
  private String enddate;
  private String approved;
  private String bankname;
}
