package com.example.payments.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
@Table(name = "USERS")
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String email;
  private String password;
  private String role;

  // @OneToOne(cascade = CascadeType.ALL)
  // @JoinColumn(name="id", referencedColumnName = "user_id")
  // public Customer customer;

  // @OneToOne(cascade = CascadeType.ALL)
  // @JoinColumn(name="id", referencedColumnName = "user_id")
  // private Customer customer;

  // @OneToOne(cascade = CascadeType.ALL)
  // @JoinColumn(name="id", referencedColumnName = "user_id")
  // private Customer customer;
}
