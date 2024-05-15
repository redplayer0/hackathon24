package com.example.payments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PaypalIban
 */
@Entity
@Data
@AllArgsConstructor
@Table(name = "PAYPAL_IBANS")
@NoArgsConstructor
@Builder
public class PaypalIban {
  @Id
  private String account;
  private String ispaypal;
  private String startdate;
  private String enddate;
  private String approved;
  private String bankname;
  private Integer vat ;
}
