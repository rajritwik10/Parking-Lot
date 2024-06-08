package com.spring.ReviseBank.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	private long Id;
	private String AccountHolderName;
	private double Balance;
}
