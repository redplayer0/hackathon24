package com.example.payments.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payments.entities.User;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  public boolean existsByEmail(String email);
  public Optional<User> findByEmail(String email);
}
