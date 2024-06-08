package com.spring.StudentManagement.Services;

import java.util.List;

import com.spring.StudentManagement.Dto.StudentDto;

public interface StudentService {
	
	public StudentDto createAccount(StudentDto studentdto);
	
	public StudentDto getStudentById(int Id);
	
	public List<StudentDto>getAll();
	
	public StudentDto getByEmail(String emailId);
	
	
	
	
}
