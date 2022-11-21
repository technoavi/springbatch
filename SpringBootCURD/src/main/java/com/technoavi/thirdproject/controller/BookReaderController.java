package com.technoavi.thirdproject.controller;

import com.technoavi.thirdproject.model.Book;
import com.technoavi.thirdproject.service.BookReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookReaderController {
    @Autowired
    BookReaderService bookReaderService;

    @GetMapping("/get/{name}")
    public String getMessage(@PathVariable String name){
        return "Hello "+name +"!!";
    }
    @PostMapping("/msg")
    public String message(@RequestBody String name){
        return "post "+name;
    }

    @PostMapping("/storeBook")
    public Book storeBook(@RequestBody Book book){
        bookReaderService.storeBook(book);
        return book;
    }


    @GetMapping("/allBooks")
    public List<Book> getAllBooks(){
       List<Book> books= bookReaderService.getAllBooks();
        return books;
    }

    @GetMapping("/getById/{id}")
    public Book getById(@PathVariable int id){
        Book book= bookReaderService.getById(id);
        return book;
    }
   @DeleteMapping("/deleteBook/{id}")
    public  String deleteBook(@PathVariable int id){

       return bookReaderService.deleteBook(id);

    }
    @GetMapping("/delete/{id}")
    public  String delBook(@PathVariable int id){

        return bookReaderService.deleteBook(id);

    }

    @PostMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
       return bookReaderService.upadteBook(book);

    }
    @PutMapping("/upBook/{id}")
    public Book upBook(@RequestBody Book book, @PathVariable int id){
        return bookReaderService.upadteBookById(book, id);

    }
    @PutMapping("/upBookbytitle/{id}/{title}")
    public Book upTitle(@PathVariable("title") String title, @PathVariable int id){
        return bookReaderService.upTitle(title, id);

    }
}
