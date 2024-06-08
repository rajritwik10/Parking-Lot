package com.spring.springrest.services;

import java.util.List;

//import org.springframework.stereotype.Component;

import com.spring.springrest.entities.Course;


public interface CourseService {
	public List<Course>getCourses();

	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);
}
