package com.spring.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {
	
	List<Course>list;
	
	
	public CourseServiceimpl() {
		list=new ArrayList<>();
		list.add(new Course(145,"java Core Course","this course contain basics of java"));
		list.add(new Course(4343,"spring-boot course","Creating RestApi using springboot"));
		
	}

	@Override
	public List<Course> getCourses() {
		
		return list;
	}
	
	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		list.add(course);
		return course;
	}


}
