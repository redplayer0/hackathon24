
package com.example.payments.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.payments.AuthService;
import com.example.payments.services.PaypalIbanService;

import com.example.payments.entities.PaypalIban;
import com.example.payments.entities.User;
import com.example.payments.entities.dtos.PaypalIbanCreateDTO;

/**
 * PaypalIbanController
 */
@RestController
public class PaypalIbanController {
  @Autowired
  private PaypalIbanService paypalIbanService;
  @Autowired
  private AuthService authService;

  @PostMapping("create_paypaliban")
  public String createPaypalIban(@RequestHeader("mycookie") String cookie, @RequestBody PaypalIbanCreateDTO paypalIbanDTO) {
    Optional<User> possibleUser = authService.getUser(cookie);
    if (!possibleUser.isEmpty()) {
      return paypalIbanService.createPaypalIban(paypalIbanDTO, possibleUser.get().getId(), possibleUser.get());
    } else {
      return "An error occured";
    }
  }
	
}
