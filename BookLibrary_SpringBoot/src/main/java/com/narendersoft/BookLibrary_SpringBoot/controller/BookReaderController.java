package com.narendersoft.BookLibrary_SpringBoot.controller;

import com.narendersoft.BookLibrary_SpringBoot.model.Book;
import com.narendersoft.BookLibrary_SpringBoot.service.BookReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookReaderController {

    @Autowired
    private BookReaderService bookReaderService;

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable int id){
        return bookReaderService.getBookById(id);
    }
    @GetMapping("/showAllBooks")
    public List<Book> showAllBooks(){
        return bookReaderService.showAllBooks();
    }

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book){
        return bookReaderService.saveBook(book);
    }


    //    @PutMapping("/updateBook/{id}")
    //    public Book updateBook(@RequestBody Book book, @PathVariable int id){
    //        return bookReaderService.updateBook(book, id);
    //
    //    }
    @PostMapping("/updateBook/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable int id){
        return bookReaderService.updateBook(book, id);

    }

    //    @DeleteMapping("/deleteBook/{id}")
    //    public String deleteBook(@PathVariable int id){
    //        return bookReaderService.deleteBook(id);
    //    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        return bookReaderService.deleteBook(id);
    }
}
