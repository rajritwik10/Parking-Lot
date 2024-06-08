package com.spring.BookAssignment.globalexceptionhandler;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.BookAssignment.Execeptions.BookNotFoundException;



@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleCannotCreateCustomerException(
    		BookNotFoundException BookEx, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(BookEx.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(BookEx.getErrCode(), BookEx.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
	 @ExceptionHandler(Exception.class)
	 public final ResponseEntity<ErrorResponse> handleBookCreateCustomerException(
	 		Exception BookEx, WebRequest request) {
				ErrorResponse error = new ErrorResponse( BookEx.getMessage());
				System.out.println("Global Exception msg");
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	 }
}

