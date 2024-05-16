package com.example.payments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payments.entities.Shop;
import com.example.payments.entities.User;
import com.example.payments.entities.dtos.ShopCreateDTO;
import com.example.payments.repositories.ShopRepository;
import com.example.payments.repositories.UserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.transaction.Transactional;

/**
 * ShopService
 */
@Service
public class ShopService {
  @Autowired
  private ShopRepository shopRepository;
  @Autowired
  private UserRepository userRepository;

  public boolean existsByVat(Integer vat) {
    return shopRepository.existsByVat(vat);
  }

  public List<Shop> findAll() {
    return shopRepository.findAll();
  }

  public void modifyBalance(Shop shop, Double amount) {
    shop.setBalance(shop.getBalance() + amount);
    shopRepository.save(shop);
  }

  @Transactional
  public String createShop(ShopCreateDTO shopDto) {
    System.out.println("CHECK shop DTO");
    System.out.println(shopDto.toString());
    if (shopRepository.existsByVat(shopDto.getVat())) {
      return "Shop already exists in the database.";
    }
    if (userRepository.existsByEmail(shopDto.getEmail())) {
      return "User already exists";
    }
    User user = User.builder()
      .email(shopDto.getEmail())
      .password(shopDto.getPassword())
      .role(shopDto.getRole())
      .build();
    userRepository.save(user);
    Shop shop = Shop.builder()
        .vat(shopDto.getVat())
        .name(shopDto.getName())
        .address(shopDto.getAddress())
        .balance(0.0)
        .picture(shopDto.getPicture())
        .userid(user.getId())
        .creationdate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        .build();
    shopRepository.save(shop);
    return "Shop record created successfully.";
  }

}
