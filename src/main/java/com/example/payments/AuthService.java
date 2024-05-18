package com.example.payments;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.payments.entities.User;
import com.example.payments.repositories.UserRepository;

/**
 * AuthService
 */
@Service
public class AuthService {
  @Autowired
  private UserRepository userRepository;

  public Optional<User> getUser(@RequestHeader("mycookie") String cookie) {
    byte[] rawCookie = Base64.getDecoder().decode(cookie);
    String[] emailPassword = new String(rawCookie, StandardCharsets.UTF_8).split(":");
    System.out.println(emailPassword.toString());
    return userRepository.findByEmailAndPassword(emailPassword[0], emailPassword[1]);
  }
}
