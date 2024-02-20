package com.ey.acountservice.web;

import com.ey.acountservice.entities.BankAccount;
import com.ey.acountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    public BankAccountRestController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository=bankAccountRepository;
    }
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount accountById(@PathVariable String id){
        return bankAccountRepository.findById(id).get();
    }
}
