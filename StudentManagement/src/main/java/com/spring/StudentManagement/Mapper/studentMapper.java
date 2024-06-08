package com.spring.StudentManagement.Mapper;

import com.spring.StudentManagement.Dto.StudentDto;
import com.spring.StudentManagement.Entities.Student;

public class studentMapper {
	public static StudentDto mapToStudentDto(Student student) {
		StudentDto studentdto=new StudentDto(
				student.getId(),
				student.getName(),
				student.getContact(),
				student.getEmailId()
				
		);
		return studentdto;
	}

	public static Student mapToStudent(StudentDto studentdto) {
		Student student=new Student(
				studentdto.getId(),
				studentdto.getName(),
				studentdto.getContact(),
				studentdto.getEmailId()
				
		);
		return student;
	}
}
