package com.narendersoft.BookLibrary_SpringBoot.service;

import com.narendersoft.BookLibrary_SpringBoot.model.Book;
import com.narendersoft.BookLibrary_SpringBoot.dao.BookReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReaderService {
    @Autowired
    private BookReaderRepository bookReaderRepository;

    public Book getBookById(int id) {
        if (id > 0) {
            return bookReaderRepository.getBookById(id);
        }
        return null;
    }

    public List<Book> showAllBooks() {
        return bookReaderRepository.getBookList();
    }

    public Book saveBook(Book book) {
        if (book != null) {
            return bookReaderRepository.saveBook(book);
        }
        return null;
    }

    public Book updateBook(Book book, int id) {
        if (book != null && id > 0) {
            return bookReaderRepository.updateBook(book, id);
        }
        return null;
    }

    public String deleteBook(int id) {
        if(id<0) return null;
        if(bookReaderRepository.deleteBook(id)){
            return "Book deleted";
        }
        else return "Book not found";

    }
}
