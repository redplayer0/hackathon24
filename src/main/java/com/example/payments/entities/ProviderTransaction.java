
package com.example.payments.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProviderTransaction
 */
@Entity
@Data
@AllArgsConstructor
@Table(name = "PROVIDER_TRANSACTIONS")
@NoArgsConstructor
@Builder
public class ProviderTransaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer transactionsid;
  private String customeraccount;
  private String provideriban;
  private Long amount;
  private String datetime;
}
