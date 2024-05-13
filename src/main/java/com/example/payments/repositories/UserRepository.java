package com.example.payments.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.payments.entities.User;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  public boolean existsByEmail(String email);
  public List<User> findByEmail(String email);

  // @Query("select * from User")
  // public List<User> userExists(String email, String password);

  @Query("select max(id) from User")
  public Long findMaxId();
}
