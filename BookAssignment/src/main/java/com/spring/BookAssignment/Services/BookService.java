package com.spring.BookAssignment.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.BookAssignment.Entities.Book;
import com.spring.BookAssignment.Execeptions.BookNotFoundException;
import com.spring.BookAssignment.dto.BookDto;

public interface BookService {
	
	public BookDto createAccout(BookDto bookdto);

	public BookDto getById(int id)throws BookNotFoundException;

	public List<BookDto> getAllBooks();
	
	public List<BookDto> getByAuthor(String author) throws BookNotFoundException;
//	
//	public BookDto getByTitle(String title);
	
	public BookDto deleteBook(int Id) throws BookNotFoundException;

	public BookDto getByTitle(String title)throws BookNotFoundException;
	
//	public Page<BookDto>Booklist(Pageable pageable);
	
	public List<BookDto> createBook(List<BookDto> books);

//	public Page<BookDto> Booklist(int page, int size, String[] sort);
	
	public List<Page<BookDto>> getAllPages(int size, String[] sort);

	
	
	
	
	
}
