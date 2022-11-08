package com.narendersoft.BookReader_SB_ResEntity.controller;

import com.narendersoft.BookReader_SB_ResEntity.model.Book;
import com.narendersoft.BookReader_SB_ResEntity.service.BookReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookReaderController {

    @Autowired
    private BookReaderService bookReaderService;

    @GetMapping("/getBookById/{bookId}")
    ResponseEntity<Book> getBookById(@PathVariable int bookId) {

        try {
            Book book = bookReaderService.getBookById(bookId);
            if(book != null){
                return new ResponseEntity<>(book, HttpStatus.OK);
            }
            else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        catch(Exception exception) {
            exception.printStackTrace(); /* printStackTrace method prints entire stack trace along with line numbers
            and class names to pinpoint the exact location of the exception.
            Note that the top-most function in the stack trace is the one where the exception occurred*/
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getAllBooks")
    ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> allBooks = bookReaderService.getAllBooks();
            if(allBooks != null) {
                return new ResponseEntity<>(allBooks, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/storeBook")
    ResponseEntity<Book> storeBook(@RequestBody Book book) {
        try {
            Book storedBook = bookReaderService.storeBook(book);
            if(storedBook != null){
                return new ResponseEntity<>(storedBook, HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            }
        }
        catch(Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/updateBook/{bookId}")
    ResponseEntity<Book> updateBook(@PathVariable int bookId, @RequestBody Book book) {
        try {
            Book updatedBook = bookReaderService.updateBook(bookId, book);
            if(updatedBook != null){
                return new ResponseEntity<>(updatedBook, HttpStatus.ACCEPTED);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            }
        }
        catch(Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/deleteBook/{bookId}")
    ResponseEntity<String> deleteBook(@PathVariable int bookId) {
        try {
            boolean ifDeleted = bookReaderService.deleteBook(bookId);
            if(ifDeleted){
                return new ResponseEntity<>("Book has been deleted.", HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Book has not been deleted.", HttpStatus.NOT_ACCEPTABLE);
            }
        }
        catch(Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
