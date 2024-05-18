package com.example.payments.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payments.entities.PaypalIban;
import com.example.payments.entities.User;
import com.example.payments.entities.dtos.PaypalIbanCreateDTO;
import com.example.payments.repositories.CustomerRepository;
import com.example.payments.repositories.PaypalIbanRepository;
import com.example.payments.repositories.ShopRepository;
import com.example.payments.repositories.UserRepository;

import jakarta.transaction.Transactional;

/**
 * PaypalIbanService
 */
@Service
public class PaypalIbanService {
  @Autowired
  private PaypalIbanRepository paypalIbanRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private ShopRepository shopRepository;
  @Autowired
  private UserRepository userRepository;

  public boolean existsByVat(Integer vat) {
    return paypalIbanRepository.existsByVat(vat);
  }

  @Transactional
  public String createPaypalIban(PaypalIbanCreateDTO paypalibanDto, Integer user_id, User user) {
    String role = user.getRole();
    Integer vat;
    if (role.equals("customer")) {
      vat = customerRepository.findByUserid(user_id).get().getVat();
    } else {
      vat = shopRepository.findByUserid(user_id).get().getVat();
    }
    if (!paypalIbanRepository.existsByAccount(paypalibanDto.getAccount())) {
      PaypalIban paypaliban = PaypalIban.builder()
          .account(paypalibanDto.getAccount())
          .ispaypal(paypalibanDto.getIspaypal())
          .bankname(paypalibanDto.getBankname())
          .vat(vat)
          .startdate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
          .approved("approved")
          .build();
      System.out.println(paypaliban.toString());
      paypalIbanRepository.save(paypaliban);
      return "PaypalIban record created successfully.";
    } else {
      return "PaypalIban already exists in the database.";
    }
  }

}
