package com.technoavi.fourthproject.controller;

import com.technoavi.fourthproject.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.technoavi.fourthproject.model.Book;
import com.technoavi.fourthproject.service.BookReaderService;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookReaderController {
    @Autowired
    BookReaderService bookReaderService;




    @Bean(name={"myBean", "mySecondBean"})
    public Book getUser() {
        return new Book();
    }

    @Autowired
    private Util u;

    @GetMapping("/get/{name}")
    public ResponseEntity<String> getMessage(@PathVariable String name){
        return new ResponseEntity<>("Heelo "+name, HttpStatus.OK);
    }
    @PostMapping("/msg")
    public String message(@RequestBody String name){
        return "post "+name;
    }

    @PostMapping("/storeBook")
    public ResponseEntity<Book> storeBook(@RequestBody Book book){

        System.out.println(u.printSMethod("storeBook ")+getUser());

    	try {
       Book res= bookReaderService.storeBook(book);
       if (res != null ) {
           System.out.println( u.printEMethod("storeBook"));
			return new ResponseEntity<>(res, HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
        //u.printSMethod("storeBook");
    }


    @GetMapping("/allBooks")
    public ResponseEntity<List<Book>>getAllBooks(){
       
   	try {
   		List<Book> res= bookReaderService.getAllBooks();
        if (res != null && res.size()>0) {
 			return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
 		} else {
 			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 		}

 	} catch (Exception e) {
 		e.printStackTrace();
 		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
 	}
    }

    @GetMapping("/getById/{id}")
    public Book getById(@PathVariable int id){
        Book book= bookReaderService.getById(id);
        return book;
    }
   @DeleteMapping("/deleteBook/{id}")
    public  ResponseEntity<String> deleteBook(@PathVariable int id){

       return new ResponseEntity<>(bookReaderService.deleteBook(id), HttpStatus.OK);

    }
    @GetMapping("/delete/{id}")
    public  String delBook(@PathVariable int id){

        return bookReaderService.deleteBook(id);

    }

    @PostMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
		try {
			Book b = bookReaderService.upadteBook(book);
			if (b != null) {
				return new ResponseEntity<>(b, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
    }
    @PutMapping("/upBook/{id}")
    public ResponseEntity<Book> upBook(@RequestBody Book book, @PathVariable int id){
    	try {
        Book b= bookReaderService.upadteBookById(book, id);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        return new ResponseEntity<>(book,HttpStatus.ACCEPTED);

    }
    @PutMapping("/upBookbytitle/{id}/{title}")
    public Book upTitle(@PathVariable("title") String title, @PathVariable int id){
        return bookReaderService.upTitle(title, id);

    }
}
