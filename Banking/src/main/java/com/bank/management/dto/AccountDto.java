package com.bank.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
 public class AccountDto {
	private Long id;
	private String accountHolderName;
	private Double balance;
	
}
