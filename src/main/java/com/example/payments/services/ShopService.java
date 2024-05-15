package com.example.payments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payments.entities.Shop;
import com.example.payments.entities.dtos.ShopCreateDTO;
import com.example.payments.repositories.ShopRepository;
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
          .build();
      System.out.println(shop.toString());
      shopRepository.save(shop);
      return "Shop record created successfully.";
    } else {
      return "Shop already exists in the database.";
    }
  }

}
