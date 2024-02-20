package com.ey.acountservice;

import com.ey.acountservice.entities.BankAccount;
import com.ey.acountservice.enums.AccountType;
import com.ey.acountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class AcountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
	return args -> {
		BankAccount bankAccount1 = BankAccount.builder()
				.accountId(UUID.randomUUID().toString())
				.currency("MAD")
				.createdAt(LocalDate.now())
				.balance(98000)
				.type(AccountType.CURRENT_ACCOUNT)
				.customerId(1L)
				.build();
		BankAccount bankAccount2 = BankAccount.builder()
				.accountId(UUID.randomUUID().toString())
				.currency("MAD")
				.createdAt(LocalDate.now())
				.balance(12000)
				.type(AccountType.SAVING_ACCOUNT)
				.customerId(2L)
				.build();

		bankAccountRepository.save(bankAccount1);
		bankAccountRepository.save(bankAccount2);
	}
			;
	}
}

