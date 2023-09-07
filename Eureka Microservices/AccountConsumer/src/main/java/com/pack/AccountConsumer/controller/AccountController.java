package com.pack.AccountConsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.AccountConsumer.entity.Account;
import com.pack.AccountConsumer.repository.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	AccountRepository accountRepo;

	@PostMapping("/accounts")
	public Account createAccount(@RequestBody Account account) {
		return accountRepo.save(account);
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts(){
		return accountRepo.findAll();
	}
	
	@GetMapping("/accounts/{id}")
	public Account getAccountById(@PathVariable("id")Integer accId) {
		return accountRepo.findById(accId).get();
	}
}
