package com.narendersoft.BookReader_SB_ResEntity.service;

import com.narendersoft.BookReader_SB_ResEntity.dao.BookReaderRepository;
import com.narendersoft.BookReader_SB_ResEntity.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReaderService {

    @Autowired
    private BookReaderRepository bookReaderRepository;
    public Book getBookById(int bookId) {
        if(bookId > 0 ) {
            return bookReaderRepository.getBookById(bookId);
        } else {
            return null;
        }
    }

    public List<Book> getAllBooks() {
        return bookReaderRepository.getAllBooks();
    }

    public Book storeBook(Book book) {
        if(book != null) {
            return bookReaderRepository.storeBook(book);
        } else {
            return null;
        }
    }

    public Book updateBook(int bookId, Book book) {
        if(bookId > 0 && book != null){
            return bookReaderRepository.updateBook(bookId, book);
        } else {
            return null;
        }
    }

    public boolean deleteBook(int bookId) {
        if(bookId > 0) {
            return bookReaderRepository.deleteBook(bookId);
        } else {
            return false;
        }
    }
}
