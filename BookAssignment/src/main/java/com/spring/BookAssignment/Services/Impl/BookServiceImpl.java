package com.spring.BookAssignment.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.BookAssignment.Entities.Book;
import com.spring.BookAssignment.Execeptions.BookNotFoundException;
import com.spring.BookAssignment.Mapper.BookMapper;
import com.spring.BookAssignment.Repository.BookRepository;
import com.spring.BookAssignment.Services.BookService;
import com.spring.BookAssignment.dto.BookDto;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookrepository;
	

	public BookServiceImpl(BookRepository bookrepository) {
		super();
		this.bookrepository = bookrepository;
	}

	@Override
	public BookDto createAccout(BookDto bookdto) {
		Book detail=BookMapper.mapToBook(bookdto);
		Book saved=bookrepository.save(detail);
		return BookMapper.mapToBookDto(saved);
	}

	@Override
	public BookDto getById(int id) throws BookNotFoundException{
		Book book=bookrepository.findById(id)
				.orElseThrow(()->new BookNotFoundException("Book Not Present"));
		return BookMapper.mapToBookDto(book);
	}

	@Override
	public List<BookDto> getAllBooks() {
		List<Book>books=bookrepository.findAll();
		return books.stream().map((book)->BookMapper.mapToBookDto(book)).collect(Collectors.toList());
	}

	@Override
	public List<BookDto> getByAuthor(String author) throws BookNotFoundException{
		List<Book>books=bookrepository
				.findByAuthor(author);
//				.orElseThrow(()->new BookNotFoundException("Book of this author is not here"));
			return books.stream().map((book)->BookMapper.mapToBookDto(book)).collect(Collectors.toList());
		
	}

	@Override
	public BookDto getByTitle(String title) throws BookNotFoundException{
		Book book=bookrepository.findByTitle(title).
//				if(book.isPresent()) {
//					throw new BookNotFoundException("Book not Exists");
//				}
				orElseThrow(()->new BookNotFoundException("Book not Exists"));
		return BookMapper.mapToBookDto(book);
	}
	
	
	public BookDto deleteBook(int Id)throws BookNotFoundException{
		Book books=bookrepository
				.findById(Id)
				.orElseThrow(()->new BookNotFoundException("Invalid Id"));
		bookrepository.delete(books);
		
		return BookMapper.mapToBookDto(books);
	}
//	@Override
//	public Page<BookDto> Booklist(Pageable pageable) {
//		Page<Book>books=bookrepository.findAll(pageable);
//		List<BookDto>bookdto=books.getContent().stream().map((book)->BookMapper.mapToBookDto(book)).collect(Collectors.toList());
//		return new PageImpl<>(bookdto,pageable,books.getTotalElements());
//	}
	
//	@Override
//	public Page<BookDto> Booklist(int page,int size,String[]sort){
//		Pageable pageable=PageRequest.of(page, size, Sort.by(sort));
//		Page<Book>nobels=bookrepository.findAll(pageable);
//		return nobels.map((Book)->BookMapper.mapToBookDto(Book));
//		
//	}

	public List<Page<BookDto>> getAllPages(int size,String[]sort){
		List<Page<BookDto>>allPages=new ArrayList<>();
		int page=0;
		Page<Book>books;
		do {
			Pageable pageable=PageRequest.of(page,size,Sort.by(sort));
			books=bookrepository.findAll(pageable);
			allPages.add(books.map((book)->BookMapper.mapToBookDto(book)));
			page++;
		}
		while(books.hasNext());
		return allPages;
	}
	@Override
	public List<BookDto> createBook(List<BookDto>newbooks) {
		// TODO Auto-generated method stub
		List<Book>books=new ArrayList();
		for(BookDto book:newbooks) {
			books.add(BookMapper.mapToBook(book));
		}
		List<Book>booklist=bookrepository.saveAll(books);
		return booklist.stream().map((book)->BookMapper.mapToBookDto(book)).collect(Collectors.toList());
	}


	
}
