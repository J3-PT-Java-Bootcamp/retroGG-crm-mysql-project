package com.example.crmmysqlproject;

import com.example.crmmysqlproject.crm.application.Crm.Crm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmMysqlProjectApplication implements CommandLineRunner {

  @Autowired
  private Crm crm;

  public static void main(String[] args) {
    SpringApplication.run(CrmMysqlProjectApplication.class, args);
  }

  @Override
  public void run(String... args) {
    this.crm.start();
  }
}
