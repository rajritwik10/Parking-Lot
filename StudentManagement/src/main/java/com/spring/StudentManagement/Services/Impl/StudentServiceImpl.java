package com.spring.StudentManagement.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.StudentManagement.Dto.StudentDto;
import com.spring.StudentManagement.Entities.Student;
import com.spring.StudentManagement.Mapper.studentMapper;
import com.spring.StudentManagement.Repository.StudentRepository;
import com.spring.StudentManagement.Services.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentrepository;

	public StudentServiceImpl(StudentRepository studentrepository) {
		this.studentrepository = studentrepository;
	}
	@Override
	public StudentDto createAccount(StudentDto studentdto) {
		Student student=studentMapper.mapToStudent(studentdto);
		Student saved=studentrepository.save(student);
		return studentMapper.mapToStudentDto(saved);
	}
	@Override
	public StudentDto getStudentById(int Id) {
		Student student=studentrepository
				.findById(Id)
				.orElseThrow(()->new RuntimeException("Student Doesnot Exists"));
		return studentMapper.mapToStudentDto(student);
	}
	@Override
	public List<StudentDto>getAll(){
		List<Student>students=studentrepository.findAll();
		return students.stream().map((student)->studentMapper.mapToStudentDto(student)).collect(Collectors.toList());
	}
	@Override
	public StudentDto getByEmail(String emailId) {
		Student student=studentrepository.findByEmail(emailId);
		return studentMapper.mapToStudentDto(student);
	}
}
