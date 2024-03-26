package com.ey.acountservice.web;

import com.ey.acountservice.client.CustomerRestClient;
import com.ey.acountservice.entities.BankAccount;
import com.ey.acountservice.model.Customer;
import com.ey.acountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;
    public BankAccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){
        this.bankAccountRepository=bankAccountRepository;
        this.customerRestClient=customerRestClient;    }
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount accountById(@PathVariable String id){
        BankAccount account = bankAccountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }
}
