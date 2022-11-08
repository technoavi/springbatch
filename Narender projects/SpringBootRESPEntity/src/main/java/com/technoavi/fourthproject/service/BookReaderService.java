package com.technoavi.fourthproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technoavi.fourthproject.dao.BookReaderRepository;
import com.technoavi.fourthproject.model.Book;

import java.util.List;

@Service
public class BookReaderService {

    @Autowired
    BookReaderRepository bookReaderRepository;
    public Book storeBook(Book book) {
        if(book!=null){
            Book bk=book;
            bookReaderRepository.storeBook(bk);
        }


        return book;
    }

    public List<Book> getAllBooks() {
      List<Book> books=  bookReaderRepository.getAllBooks();
      return books;
    }
    public Book getById(int id) {
       Book book=  bookReaderRepository.getById(id);
        return book;
    }

    public String deleteBook(int id) {
        return  bookReaderRepository.deleteBook(id);
    }

    public Book upadteBook(Book book) {
        if (book != null) {

            return bookReaderRepository.updateBook(book);
        }
        new Exception("No record found!");
return null;
    }

    public Book upadteBookById(Book book, int id) {


            return bookReaderRepository.upadteBookById(book, id);



    }

    public Book upTitle(String title, int id) {
        return bookReaderRepository.upTitle(title, id);
    }
}
