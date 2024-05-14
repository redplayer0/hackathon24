package com.example.payments.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
  private String first_name;
  private String last_name;
  private String birthday;
  private String birth_address;
  private Long weekly_tranfer;
  private Long weekly_limit;
  private Long balance;
  private String creation_date;
  private String deletion_date;
  private Integer user_id;


}
