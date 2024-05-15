package com.example.payments.repositories;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.payments.entities.Provider;

/**
 * UserRepository
 */
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {
  @Query(nativeQuery = true, value = "select * from PROVIDER limit 1")
  public Provider getProvider();
}
