package com.bank.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.management.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
