package com.spring.StudentManagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
	public int Id;
	public String name;
	public String contact;
	public String emailId;
	
}
