package com.spring.BookAssignment.Mapper;

import com.spring.BookAssignment.Entities.Book;
import com.spring.BookAssignment.dto.BookDto;

public class BookMapper {

	public static BookDto mapToBookDto(Book book) {
		BookDto bookdto=new BookDto(
				book.getId(),
				book.getName(),
				book.getTitle(),
				book.getAuthor(),
				book.getPrice()
		);
		
		return bookdto;
	}
	public static Book mapToBook(BookDto bookdto) {
		Book book=new Book(
				bookdto.getId(),
				bookdto.getName(),
				bookdto.getTitle(),
				bookdto.getAuthor(),
				bookdto.getPrice()
		);
		return book;
	}
}
