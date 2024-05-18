package com.example.payments.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
  public List<String> getShops() {
    return shopService.findAll().stream().map(shop -> shop.getName()).collect(Collectors.toList());
  }

  @PostMapping("create_shop")
  public String createShop(@RequestBody ShopCreateDTO shopDTO) {
    return shopService.createShop(shopDTO);
  }
}
