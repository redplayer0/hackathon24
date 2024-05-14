package com.example.payments.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payments.entities.User;
import com.example.payments.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  @Transactional
  public String createUser(User user) {
    if (!userRepository.existsByEmail(user.getEmail())) {
      userRepository.save(user);
      return "User record created successfully.";
    } else {
      return "User already exists in the database.";
    }
  }

  public List<User> readUsers() {
    return userRepository.findAll();
  }

  public String getUserRole(String email) {
    Optional<User> possibleUser = userRepository.findByEmail(email);
    if (!possibleUser.isEmpty()) {
      return possibleUser.get().getEmail();
    } else {
      return "User does not exist";
    }
  }

  @Transactional
  public String deleteUser(User user) {
    if (userRepository.existsByEmail(user.getEmail())) {
      Optional<User> possibleUser = userRepository.findByEmail(user.getEmail());
      if (!possibleUser.isEmpty()) {
        userRepository.delete(user);
        return "User record deleted successfully.";
      } else {
        return "User does not exist";
      }
    } else {
      return "User does not exist";
    }
  }
}
