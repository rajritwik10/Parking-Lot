package com.bank.management.mapper;

import com.bank.management.dto.AccountDto;
import com.bank.management.entities.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDto accountDto) {
		Account account=new Account(
			accountDto.getId(),
			accountDto.getAccountHolderName(),
			accountDto.getBalance()
		);
		
		return account;	
	}
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto= new AccountDto(
			account.getId(),
			account.getAccountHolderName(),
			account.getBalance()
		);
		return accountDto;
	}
}
