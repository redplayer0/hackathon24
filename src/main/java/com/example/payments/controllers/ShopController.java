package com.example.payments.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.payments.AuthService;
import com.example.payments.entities.Shop;
import com.example.payments.entities.User;
import com.example.payments.entities.dtos.ShopCreateDTO;
import com.example.payments.repositories.ShopRepository;
import com.example.payments.services.ShopService;

/**
 * ShopController
 */
@RestController
public class ShopController {
  @Autowired
  private ShopService shopService;
  @Autowired
  private AuthService authService;

  @GetMapping("shops")
  public List<Shop> getShops() {
    return shopService.findAll();
  }

  @PostMapping("create_shop")
  public String createShop(@RequestHeader("Cookie") String cookie, @RequestBody ShopCreateDTO shopDTO) {
    Optional<User> possibleUser = authService.getUser(cookie);
    if (!possibleUser.isEmpty()) {
      return shopService.createShop(shopDTO, possibleUser.get().getId());
    } else {
      return "An error occured";
    }
  }
}
