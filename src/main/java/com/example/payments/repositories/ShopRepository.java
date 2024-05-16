package com.example.payments.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payments.entities.Shop;

/**
 * ShopRepository
 */
@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
  public boolean existsByUserid(Integer UserId);
  public boolean existsByVat(Integer vat);
  public Optional<Shop> findByVat(Integer vat);
  public Optional<Shop> findByName(String name);
  public Optional<Shop> findByUserid(Integer userid);
  public List<Shop> findAll();
}
