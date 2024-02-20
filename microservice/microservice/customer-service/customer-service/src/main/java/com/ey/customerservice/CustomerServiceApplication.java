package com.ey.customerservice;

import com.ey.customerservice.entities.Customer;
import com.ey.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {

			List<Customer> customersList=List.of( Customer.builder()
							.firstName("Ey")
							.lastName("Tsek")
							.email("ey.tsek@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Kais")
							.lastName("Os")
							.email("kais.os@gmail.com")
							.build()

			);

			customerRepository.saveAll(customersList);
		};
	}
}

