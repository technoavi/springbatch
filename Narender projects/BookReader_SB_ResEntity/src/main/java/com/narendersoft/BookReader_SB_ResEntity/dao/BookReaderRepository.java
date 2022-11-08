package com.narendersoft.BookReader_SB_ResEntity.dao;

import com.narendersoft.BookReader_SB_ResEntity.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookReaderRepository {
    List<Book> bookList;

    public BookReaderRepository() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1, "Let us C", "Yaswant Kathnekar"));
        bookList.add(new Book(2, "Let us C++", "Yaswant Kathnekar"));
        bookList.add(new Book(3, "Java 1.8", "James Gosling"));
    }

    public Book getBookById(int bookId) {
        for(int i = 0; i < bookList.size(); ++i) {
            if(bookId == bookList.get(i).getId()) {
                return bookList.get(i);
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book storeBook(Book book) {
        Book newBook = new Book();
        newBook.setId(book.getId());
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        bookList.add(newBook);
        return newBook;
    }

    public Book updateBook(int bookId, Book book) {
        Book bookToBeUpdated = getBookById(bookId);
        if(bookToBeUpdated != null){
           bookToBeUpdated.setTitle(book.getTitle());
           bookToBeUpdated.setAuthor(book.getAuthor());
           return bookToBeUpdated;
        }
        else {
            return null;
        }
    }

    public boolean deleteBook(int bookId) {
        Book bookToBeDeleted = getBookById(bookId);
        if(bookToBeDeleted != null) {
            bookList.remove(bookToBeDeleted);
            return true;
        }
        else {
            return false;
        }

    }
}
