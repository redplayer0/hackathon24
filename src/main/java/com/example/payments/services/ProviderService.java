package com.example.payments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payments.entities.Provider;
import com.example.payments.repositories.ProviderRepository;

@Service
public class ProviderService {
  @Autowired
  private ProviderRepository providerRepository;

  public void modifyBalance(Long amount) {
    Provider provider = providerRepository.getProvider();
    provider.setBalance(provider.getBalance() + amount);
    providerRepository.save(provider);
  }
}


