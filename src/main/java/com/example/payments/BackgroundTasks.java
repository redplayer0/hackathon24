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

  @Scheduled(cron = "0 */1 * * * *")
  // @Scheduled(cron = "*/1 * * * * *")
  public void weekly() {
    transactionService.processPendingTransactions();
    long now = System.currentTimeMillis() / 1000;
    System.out.println(
        "Weekly Background process" + now);
  }

  @Scheduled(cron = "0 */2  * * * *")
  // @Scheduled(cron = "*/2 * * * * *")
  public void monthly() {
    transactionService.processRecievedTransactions();
    long now = System.currentTimeMillis() / 1000;
    System.out.println(
        "Monthly Background process" + now);
  }

}
