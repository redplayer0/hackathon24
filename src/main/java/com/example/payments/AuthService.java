
package com.example.payments;

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

  public Optional<User> getUser(@RequestHeader("cookie") String cookie) {

    String[] emailRole = Base64.getDecoder().decode(cookie).toString().split(":");
    return userRepository.findByEmailAndPassword(emailRole[0], emailRole[1]);
  }
}
