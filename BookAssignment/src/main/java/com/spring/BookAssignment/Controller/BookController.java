package com.spring.BookAssignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.BookAssignment.Entities.Book;
import com.spring.BookAssignment.Execeptions.BookNotFoundException;
import com.spring.BookAssignment.Services.BookService;
import com.spring.BookAssignment.dto.BookDto;

@RestController
@RequestMapping("/api/Book")
public class BookController {
	@Autowired
	private BookService bookservice;

	public BookController(BookService bookservice) {
		super();
		this.bookservice = bookservice;
	}
	//REST API for adding Book in DATABASE
	@PostMapping()
	public ResponseEntity<BookDto>createAccount(@RequestBody BookDto bookdto) {
		return new ResponseEntity<>(bookservice.createAccout(bookdto),HttpStatus.OK);
	}
	
	
	@GetMapping()
	public ResponseEntity<List<BookDto>>getAllBooks(){
		List<BookDto>books=bookservice.getAllBooks();
		return ResponseEntity.ok(books);
	}
	//REST API Calling By Id
	@GetMapping("/{Id}")
	public ResponseEntity<BookDto> getById(@PathVariable int Id) throws BookNotFoundException {
		BookDto booktem=bookservice.getById(Id);
		return ResponseEntity.ok(booktem);
	}
	@GetMapping("/author")
	public ResponseEntity<List<BookDto>> getByAuthor(@RequestParam("author") String author) throws BookNotFoundException{
		List<BookDto> Booklist=bookservice.getByAuthor(author);
		return ResponseEntity.ok(Booklist);
	}
	
	
	@GetMapping("/title")
	public ResponseEntity<BookDto> getByTitle(@RequestParam("title") String title) throws BookNotFoundException {
		BookDto bookes=bookservice.getByTitle(title);
		return ResponseEntity.ok(bookes);
	}
	
	//REST API to Remove Book from db
	@DeleteMapping("/{Id}")
	public ResponseEntity<BookDto> deleteById(@PathVariable int Id) throws BookNotFoundException{
		BookDto temp=bookservice.deleteBook(Id);
		return ResponseEntity.ok(temp);
	}
	
	//GET DATA IN FORMAT OF PAGE
	
//	@GetMapping("/Booklist")
//	public ResponseEntity<Page<BookDto>>getBooks(
//			@RequestParam(defaultValue="0")int page,
//			@RequestParam(defaultValue="10")int size,
//			@RequestParam(defaultValue="id")String[] sort
//	){
//		Page<BookDto> nobels=bookservice.Booklist(page,size,sort);
//		return ResponseEntity.ok(nobels);
//		
////		Pageable pageable=PageRequest.of(page, size,Sort.by(sortBy));
//		
//	}
//	@GetMapping("/Booklist")
//	public ResponseEntity<Page<BookDto>>Booklist(Pageable pageable){
//		Page<BookDto> books=bookservice.Booklist(pageable);
//		return ResponseEntity.ok(books);
//	}
	
//	@PostMapping("/createBook")
//	public ResponseEntity<List<BookDto>>createBook(@RequestBody List<BookDto>books){
//		List<BookDto>booked=bookservice.createBook(books);
//		return ResponseEntity.ok(booked);
//	}
	
	@GetMapping("/Booklist")
	public ResponseEntity<List<Page<BookDto>>>getAllPages(
			@RequestParam(defaultValue ="10") int size,
			@RequestParam(defaultValue ="id") String[]sort)
	{
		List<Page<BookDto>> allPages=bookservice.getAllPages(size, sort);
		return ResponseEntity.ok(allPages);
		
	}
	
	
}
