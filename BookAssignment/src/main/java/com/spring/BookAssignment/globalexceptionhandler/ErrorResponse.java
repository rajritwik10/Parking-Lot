package com.spring.BookAssignment.globalexceptionhandler;


import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;

	private int errCode;

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorResponse() {
		timestamp = new Date();
		errCode=123;
		message="Sorry Boss Data Not Available";
	}

	public ErrorResponse(String message) {
		this();
		this.message = message;
	}

	public ErrorResponse(int errCode, String message) {
		this();
		this.errCode = errCode;
		this.message = message;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getErrCode() {
		return errCode;
	}
	
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
	
	public String getMessage() {
		return message;
	}

}