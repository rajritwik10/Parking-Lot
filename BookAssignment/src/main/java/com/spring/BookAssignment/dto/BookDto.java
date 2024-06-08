package com.spring.BookAssignment.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
	private int Id;
	private String Name;
	private String Title;
	private String Author;
	private Double Price;
}
