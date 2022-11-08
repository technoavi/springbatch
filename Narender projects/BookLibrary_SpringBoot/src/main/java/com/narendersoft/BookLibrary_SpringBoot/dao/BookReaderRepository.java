package com.narendersoft.BookLibrary_SpringBoot.dao;

import com.narendersoft.BookLibrary_SpringBoot.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookReaderRepository {
    private final List<Book> bookList;

    public BookReaderRepository() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1, "Let us C", "Yeswanth Kathnekar"));
        bookList.add(new Book(2, "Python 3", "Guido van Rossum"));
    }
    public Book getBookById(int id) {

        for(Book book : bookList) {
            if (book.getId() == id) return book;
        }
        return null;
    }



    //returns all books available in the list
    public List<Book> getBookList() {
        return bookList;
    }

    //adding new book to the list
    public Book saveBook(Book book) {
        Book newBook = new Book();
        newBook.setId(book.getId());
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        bookList.add(newBook);
        return newBook;
    }

    public Book updateBook(Book book, int id) {
        if(getBookById(id) != null) {
            Book bookToUpdate = getBookById(id);
            bookToUpdate.setId(book.getId());
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setAuthor(book.getAuthor());
            return bookToUpdate;
        }
        return null;
    }

    //deleteBook returns true if book is available and if the book is removed
    public boolean deleteBook(int id) {
        Book bookToDelete = getBookById(id);
        if(bookToDelete != null){
            bookList.remove(bookToDelete);
            return true;
        }
        return false;
    }
}
