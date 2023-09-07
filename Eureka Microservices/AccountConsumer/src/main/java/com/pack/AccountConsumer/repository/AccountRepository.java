package com.pack.AccountConsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.AccountConsumer.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
