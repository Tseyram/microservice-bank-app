package com.ey.acountservice.entities;

import java.time.LocalDate;

import com.ey.acountservice.enums.AccountType;
import com.ey.acountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

  
public class BankAccount {

   @Id
   private String accountId ;
   private double balance;
   private LocalDate createdAt;
   private String currency;
   @Enumerated(EnumType.STRING)
   private AccountType type;
   @Transient
   private Customer customer;
   private Long customerId;
}
