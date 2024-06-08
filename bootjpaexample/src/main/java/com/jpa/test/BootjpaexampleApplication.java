package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository =context.getBean(UserRepository.class);
		
//		User user=new User();
//		user.setName("Ritwik Raj");
//		user.setCity("Begusarai");
//		user.setStatus("I am a Java Programmer");
//		
//		User user1=userRepository.save(user);
//		System.out.println(user1);
		
		//create object of user
//		User user1=new User();
//		user1.setName("uttam");
//		user1.setCity("city1");
//		user1.setStatus("Python Programmer");
//		
//		User user2=new User();
//		user2.setName("Aniket");
//		user2.setCity("city2");
//		user2.setStatus("C++ Programmer");
//		
////		User resultUser=userRepository.save(user2);
//		List<User>users=List.of(user1,user2);
//		Iterable<User>result=userRepository.saveAll(users);
//		result.forEach(user->{
//			System.out.println(user);
//		});
////		System.out.println("saved user is"+users);
//		System.out.println("done");
		
		
//		update user of id 153
		
//		Optional<User>optional=userRepository.findById(153);
//		
//		User user = optional.get();
//		user.setName("Ramesh Tiwari");
//		User result = userRepository.save(user);
//		System.out.println(result);
		
		Iterable<User>itr=userRepository.findAll();
		
		//iterating users
//		Iterator<User>iterator=itr.iterator();
//		
//		while(iterator.hasNext()) {
//			User user=iterator.next();
//			System.out.println(user);
//		}
		
//		itr.forEach(new Consumer<User>() {
//
//			@Override
//			public void accept(User t) {
//				// TODO Auto-generated method stub
//				System.out.println(t);
//				
//			}
//			
//		});
		//another method to implement
//		itr.forEach(user->{
//			System.out.println(user);
//		});
//		userRepository.deleteById(153);
//		System.out.println("user deleted");
		
		//anoher
//		Iterable<User>allUsers=userRepository.findAll();
//		allUsers.forEach(user->System.out.println(user));
//		userRepository.deleteAll(allUsers);
		
		
//		List<User> users=userRepository.findByName("Ritwik Raj");
//		users.forEach(e->System.out.println(e));
		
		List<User> allUser=userRepository.getAllUser();
		allUser.forEach(e->{
			System.out.println(e);
		});
		List<User> userByName=userRepository.getUserByName("Aniket","city2");
		userByName.forEach(e->{
			System.out.println(e);
		});
		
		System.out.println("__________________________________");
		userRepository.getUsers().forEach(e->{
			System.out.println(e);
		});
		
	}

}
