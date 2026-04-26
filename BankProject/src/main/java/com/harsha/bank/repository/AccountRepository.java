package com.harsha.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsha.bank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}