package com.example.payments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.payments.entities.User;
import com.example.payments.services.UserService;

import jakarta.validation.Valid;

/**
 * UserController
 */
@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("info")
  public String info() {
    return "The application is up...";
  }

  @PostMapping("create_user")
  public String createUser(@Valid @RequestBody User user) {
    return userService.createUser(user);
  }

  @GetMapping("read_users")
  public List<User> readUsers() {
    return userService.readUsers();
  }

  @PutMapping("update_user")
  public String updateStudet(@RequestBody User user) {
    return userService.updateUser(user);
  }

  @DeleteMapping("delete_user")
  public String deleteUser(@RequestBody User user) {
    return userService.deleteUser(user);
  }
}
