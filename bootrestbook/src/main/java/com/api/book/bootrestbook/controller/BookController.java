package com.api.book.bootrestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;




@RestController
public class BookController {
    
    // @RequestMapping(value="/books", method=RequestMethod.GET)
    
    // @ResponseBody
    // public String requestMethodName(@RequestParam String param) {
    //     return new String();
    // }

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> getBook(){
        return this.bookService.getAllBooks();
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    {
        Book b=this.bookService.addBook(book);
        return b;
    }
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);
        
    }

    //update book handler
    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        this.bookService.updateBook(book,bookId);
        return book;
    }



    // public Book getBooks(){
    //     Book book=new Book();
    //     book.setId(12324);
    //     book.setTitle("Java Complete Reference");
    //     book.setAuthor("XYZ");
    //     return book;
    // }
}
