package com.pack.AccountsWeb1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pack.AccountsWeb1.model.Account;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	RestTemplate restTemplate;
	

	@PostMapping("/accounts")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		try {
			Account acc=restTemplate.postForObject("http://ACCOUNTS-CONSUMER/accounts", account, Account.class);
			return new ResponseEntity<>(acc, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		try {
			 Account[] accounts=restTemplate.getForObject("http://ACCOUNTS-CONSUMER/accounts", Account[].class);
			 List<Account> list=Arrays.asList(accounts);
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable("id") Integer id) {
		Account acc=restTemplate.getForObject("http://ACCOUNTS-CONSUMER/accounts/{id}", Account.class, id);
		if (acc!=null) {
			return new ResponseEntity<>(acc, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
