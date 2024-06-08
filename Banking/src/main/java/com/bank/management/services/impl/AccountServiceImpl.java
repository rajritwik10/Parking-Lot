package com.bank.management.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.management.Repository.AccountRepository;
import com.bank.management.dto.AccountDto;
import com.bank.management.entities.Account;
import com.bank.management.mapper.AccountMapper;
import com.bank.management.services.AccountService;


@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountrepository;
	
	public AccountServiceImpl(AccountRepository accountrepository) {
//		super();
		this.accountrepository = accountrepository;
	}
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount=accountrepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	@Override
	public AccountDto getAccountById(Long id) {
		Account account=accountrepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account doesnot Exists"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account=accountrepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account doesnot Exists"));
		double total=account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount=accountrepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		
		Account account=accountrepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account doesnot Exist"));
		
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		double total=account.getBalance()-amount;
		account.setBalance(total);
		
		Account savedAccount=accountrepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account>accounts=accountrepository.findAll();
		return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account))
		   .collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long id) {
		Account account=accountrepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account doesnot Exists"));
		
		accountrepository.deleteById(id);
		
	}
	
	
}
