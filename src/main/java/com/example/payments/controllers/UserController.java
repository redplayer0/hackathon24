package com.example.payments.controllers;

import java.net.http.HttpHeaders;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.payments.entities.Provider;
import com.example.payments.entities.User;
import com.example.payments.entities.dtos.UserLoginDTO;
import com.example.payments.repositories.ProviderRepository;
import com.example.payments.services.ProviderService;
import com.example.payments.services.UserService;
import com.fasterxml.jackson.core.Base64Variant;

import ch.qos.logback.core.joran.conditional.PropertyWrapperForScripts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

/**
 * UserController
 */
@RestController
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private ProviderRepository providerRepository;
  @Autowired
  private ProviderService providerService;

  @GetMapping("test")
  public String info() {
    providerService.modifyBalance(-10L);
    Provider provider = providerRepository.getProvider();
    return provider.toString();
  }

  @PostMapping("signup")
  public String createUser(@Valid @RequestBody User user) {
    return userService.createUser(user);
  }

  @PostMapping("login")
  public ResponseEntity<String> loginUser(@Valid @RequestBody UserLoginDTO user) {
    if (userService.authenticateUser(user)) {
      String emailPassword = user.getEmail() + ":" + user.getPassword();
      String cookie = Base64.getEncoder().encodeToString(emailPassword.getBytes());
      return ResponseEntity.ok()
          .header("cookie", cookie)
          .body("Login Succesful");

    } else {
      return ResponseEntity.ok()
          .body("Wrong credentials");
    }
  }

  @GetMapping("read_users")
  public List<User> readUsers() {
    return userService.readUsers();
  }

  // @PutMapping("update_user")
  // public String updateStudet(@RequestBody User user) {
  // return userService.updateUser(user);
  // }

  @DeleteMapping("delete_user")
  public String deleteUser(@RequestBody User user) {
    return userService.deleteUser(user);
  }
}
