package com.spring.ReviseBank.Services.Impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ReviseBank.Dto.AccountDto;
import com.spring.ReviseBank.Mapper.AccountMapper;
import com.spring.ReviseBank.Repository.AccountRepository;
import com.spring.ReviseBank.entities.Account;

@Service
public class AccountServiceImpl {
	@Autowired
	private AccountRepository accountrepository;
	
	
	public AccountServiceImpl(AccountRepository accountrepository) {
		this.accountrepository = accountrepository;
	}
	@Override
	public AccountDto getAccountById(Long Id) {
		Account account=accountrepository.findById(Id)
				.orElseThrow(()->new RuntimeException("accountDoes not exists"));
		return AccountMapper.mapToAccountDto(account);
	}
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount=accountrepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	@Override
	public AccountDto withdraw(Long id,Double amount) {
		Account account=accountrepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("account doesnot exists"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		else {
			double total=account.getBalance()-amount;
			account.setBalance(total);
		}
		Account savedbalance=accountrepository.save(account);
		return AccountMapper.mapToAccountDto(savedbalance);
	}
	@Override
	public AccountDto deposit(Long id,Double amount){
		Account account=accountrepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account doesnot exists"));
		double total=account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount=accountrepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
			
	}
	@Override
	public List<AccountDto>getAllAccount(){
		List<Account>accounts=accountrepository.findAll();
		return accounts.stream().map((account)->AccountMapper.mapToAccount(account))
				.collect(Collectors.toList());
		
	}
	@Override
	public String delete(Long Id) {
		Account account=accountrepository.findById(Id)
				.orElseThrow(()->new RuntimeException("account Doesnot exists"));
		accountrepository.deleteById(Id);
		return "Successfully Removed";
	}
	
	
	
	
}
