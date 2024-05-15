package com.example.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.payments.services.TransactionService;

/**
 * BackgroundTasks
 */
@Configuration
@EnableScheduling
public class BackgroundTasks {
  @Autowired
  private TransactionService transactionService;

  @Scheduled(cron = "0 */3 * * * *")
  public void weekly() {
    long now = System.currentTimeMillis() / 1000;
    System.out.println(
        "schedule tasks using cron jobs - " + now);
  }

  @Scheduled(cron = "0 */6 * * * *")
  public void monthly() {

    long now = System.currentTimeMillis() / 1000;
    System.out.println(
        "schedule tasks using cron jobs - " + now);
  }

}
