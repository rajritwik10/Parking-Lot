package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {
    private static List<Book>list=new ArrayList<>();
    static{
        list.add(new Book(12,"java Reference","XYZ"));
        list.add(new Book(36,"Head first to java Reference","qwe"));
        list.add(new Book(42,"Python Reference","abc"));
    }
    // get all books
    public List<Book>getAllBooks(){
        return list;
    }
    // single book
    public Book getBookById(int id){
        Book book=null;
        list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    //adding hthe bbok
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    //Delete Book
    public void deleteBook(int bid)
    {
        list=list.stream().filter(book->
        {
            if(book.getId()!=bid)
            {
                return true;
            }
            else{
                return false;
            }
        }).collect(Collectors.toList());
        //filter(book->book.getId()!=bid).collect
        
    }

    //Update Book Detail
    public void updateBook(Book book, int bookId) {
        list=list.stream().map(b->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
        // throw new UnsupportedOperationException("Unimplemented method 'updateBook'");
    }
}
