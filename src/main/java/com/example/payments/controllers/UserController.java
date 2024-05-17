package com.example.payments.controllers;

import java.net.http.HttpHeaders;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.payments.entities.Provider;
import com.example.payments.entities.User;
import com.example.payments.entities.dtos.UserLoginDTO;
import com.example.payments.repositories.ProviderRepository;
import com.example.payments.repositories.UserRepository;
import com.example.payments.services.CustomerService;
import com.example.payments.services.ProviderService;
import com.example.payments.services.ShopService;
import com.example.payments.services.UserService;
import com.fasterxml.jackson.core.Base64Variant;
import org.springframework.http.MediaType;

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
    providerService.modifyBalance(-10.0);
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
      String role = userService.getUserRole(user.getEmail());
      return ResponseEntity.ok()
          .header("mycookie", cookie)
          .header("myrole", role)
          .body("Login Succesful");
    } else {
      return ResponseEntity.ok()
          .body("Wrong credentials");
    }
  }

  @GetMapping(value = "read_users")
  public ResponseEntity<List<User>> readUsers() {
    return ResponseEntity.ok(userService.readUsers());
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
