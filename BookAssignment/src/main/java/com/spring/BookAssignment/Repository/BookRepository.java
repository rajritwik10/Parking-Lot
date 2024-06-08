package com.spring.BookAssignment.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.BookAssignment.Entities.Book;
import com.spring.BookAssignment.Execeptions.BookNotFoundException;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

	@Query("SELECT b FROM Book b WHERE b.Author = :author")
	List<Book> findByAuthor(@Param("author") String author);
	
	@Query("SELECT b FROM Book b WHERE b.Title = :title")
	Optional<Book>findByTitle(@Param("title")String title) throws BookNotFoundException;
	
	Page<Book> findAll(Pageable pageable);
	

}
