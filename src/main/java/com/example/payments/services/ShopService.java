package com.example.payments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payments.entities.Shop;
import com.example.payments.entities.dtos.ShopCreateDTO;
import com.example.payments.repositories.ShopRepository;

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

  public boolean existsByVat(Integer vat) {
    return shopRepository.existsByVat(vat);
  }

  public List<Shop> findAll() {
    return shopRepository.findAll();
  }

  public void modifyBalance(Shop shop, Long amount) {
    shop.setBalance(shop.getBalance() + amount);
    shopRepository.save(shop);
  }

  @Transactional
  public String createShop(ShopCreateDTO shopDto, Integer user_id) {
    System.out.println("CHECK shop DTO");
    System.out.println(shopDto.toString());
    if (!shopRepository.existsByVat(shopDto.getVat())) {
      Shop shop = Shop.builder()
          .vat(shopDto.getVat())
          .name(shopDto.getName())
          .address(shopDto.getAddress())
          .balance(0L)
          .picture(shopDto.getPicture())
          .userid(user_id)
          .creationdate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
          .build();
      System.out.println(shop.toString());
      shopRepository.save(shop);
      return "Shop record created successfully.";
    } else {
      return "Shop already exists in the database.";
    }
  }

}
