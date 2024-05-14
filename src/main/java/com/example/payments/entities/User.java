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
 * User
 */
@Entity
@Data
@AllArgsConstructor
@Table(name = "USERS")
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long user_id;
  private String email;
  private String password;
  private String role;

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long id) {
    this.user_id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

}
