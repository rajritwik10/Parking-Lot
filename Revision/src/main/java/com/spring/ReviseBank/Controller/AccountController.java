package com.spring.ReviseBank.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ReviseBank.Dto.AccountDto;
import com.spring.ReviseBank.Services.AccountService;

@RestController
@RequestMapping("/api/revise")
public class AccountController {
	@Autowired
	private AccountService accountservice;

	public AccountController(AccountService accountservice) {
		super();
		this.accountservice = accountservice;
	}
	@PostMapping("/addAccount")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountservice.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long Id){
		AccountDto accountDto=accountservice.getAccountById(Id);
		return ResponseEntity.ok(accountDto);
	}
	@GetMapping()
	public ResponseEntity<List<AccountDto>>getAllAccounts(){
		List<AccountDto>accounts=accountservice.getAllAccount();
		return ResponseEntity.ok(accounts);
	}
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto>withdraw(@PathVariable Long Id,@RequestBody Map<String,Double>request){
		Double amount=request.get("amount");
		AccountDto accountDto=accountservice.withdraw(Id,amount);
		return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto>deposit(@PathVariable Long Id,@RequestBody Map<String,Double>request){
		Double amount=request.get("amount");
		AccountDto accountDto=accountservice.deposit(Id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	
	
}
