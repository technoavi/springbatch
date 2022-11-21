package com.technoavi.thirdproject.controller;


import com.technoavi.thirdproject.dao.BookRepository;
import com.technoavi.thirdproject.exception.ResourceNotFoundException;
import com.technoavi.thirdproject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController  {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book comment) {
        return bookRepository.save(comment);
    }
    @GetMapping("/books/{id}")
    public Book getCommentById(@PathVariable(value = "id") Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("book", "id", bookId));
    }

    @PutMapping("/books/{id}")
    public Book updateComment(@PathVariable(value = "id") Long commentId, @RequestBody Book bookDetails) {

        Book book = bookRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        book.setGenre(bookDetails.getGenre());
        book.setTitle(bookDetails.getTitle());

        Book bookComment = bookRepository.save(book);
        return bookComment;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "id") Long commentId) {
        Book comment = bookRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        bookRepository.delete(comment);

        return ResponseEntity.ok().build();
    }
}