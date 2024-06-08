package com.spring.StudentManagement.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.StudentManagement.Dto.StudentDto;
import com.spring.StudentManagement.Services.StudentService;

@RestController
@RequestMapping("api/student")
public class studentController {
	@Autowired
	private StudentService studentservice;

	public studentController(StudentService studentservice) {
//		super();
		this.studentservice = studentservice;
	}
	
	@PostMapping
	public ResponseEntity<StudentDto> createAccount(@RequestBody StudentDto studentdto) {
		return new ResponseEntity<>(studentservice.createAccount(studentdto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<StudentDto> getById(@PathVariable int Id){
		StudentDto studentdto=studentservice.getStudentById(Id);
		return ResponseEntity.ok(studentdto);
	}
	
	@GetMapping()
	public ResponseEntity<List<StudentDto>>getAll(){
		List<StudentDto>students=studentservice.getAll();
		return ResponseEntity.ok(students);
	}
	
	@GetMapping("/{emailId}")
	public ResponseEntity<StudentDto>getByEmail(@RequestBody String emailId){
		StudentDto studentdto=studentservice.getByEmail(emailId);
		return ResponseEntity.ok(studentdto);
	}
	
//	public ResponseEntity<StudentDto>change
	
}
