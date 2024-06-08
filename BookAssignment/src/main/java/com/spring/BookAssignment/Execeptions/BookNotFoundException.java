package com.spring.BookAssignment.Execeptions;

public class BookNotFoundException extends BaseException{
	
	public BookNotFoundException() {
		super();
		
	}
	public BookNotFoundException(String message) {
		super(message);
	}
}
