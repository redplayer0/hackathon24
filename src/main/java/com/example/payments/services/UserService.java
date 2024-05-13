package com.example.payments.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.payments.entities.User;
import com.example.payments.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public User saveUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  public boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  @Transactional
  public String createUser(User user) {
    try {
      if (!userRepository.existsByEmail(user.getEmail())) {
        user.setId(null == userRepository.findMaxId() ? 0 : userRepository.findMaxId() + 1);
        userRepository.save(user);
        return "User record created successfully.";
      } else {
        return "User already exists in the database.";
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public List<User> readUsers() {
    return userRepository.findAll();
  }

  @Transactional
  public String updateUser(User user) {
    if (userRepository.existsByEmail(user.getEmail())) {
      try {
        List<User> users = userRepository.findByEmail(user.getEmail());
        users.stream().forEach(s -> {
          User userToBeUpdate = userRepository.findById(s.getId()).get();
          userToBeUpdate.setEmail(user.getEmail());
          userToBeUpdate.setPassword(user.getPassword());
          userRepository.save(userToBeUpdate);
        });
        return "User record updated.";
      } catch (Exception e) {
        throw e;
      }
    } else {
      return "User does not exists in the database.";
    }
  }

  @Transactional
  public String deleteUser(User user) {
    if (userRepository.existsByEmail(user.getEmail())) {
      try {
        List<User> users = userRepository.findByEmail(user.getEmail());
        users.stream().forEach(s -> {
          userRepository.delete(s);
        });
        return "User record deleted successfully.";
      } catch (Exception e) {
        throw e;
      }

    } else {
      return "User does not exist";
    }
  }
}
