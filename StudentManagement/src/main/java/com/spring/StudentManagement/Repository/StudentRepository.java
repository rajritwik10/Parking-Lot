package com.spring.StudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.StudentManagement.Entities.Student;


public interface StudentRepository extends JpaRepository<Student,Integer>{

//	Student findByEmail(String emailId);
	public Student findByEmail(String emailId) ; 
	
}
