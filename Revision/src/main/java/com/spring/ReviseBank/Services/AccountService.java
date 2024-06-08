package com.spring.ReviseBank.Services;

import java.util.List;

import com.spring.ReviseBank.Dto.AccountDto;

public interface AccountService{
	
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(Long Id);
	
	AccountDto withdraw(Long Id,Double amount);
	
	AccountDto deposit(Long Id,Double amount);
	
	AccountDto delete(Long Id);
	
	List<AccountDto>getAllAccount();
	
}
