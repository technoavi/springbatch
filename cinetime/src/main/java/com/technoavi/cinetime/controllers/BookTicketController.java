package com.technoavi.cinetime.controllers;


import com.technoavi.cinetime.dao.model.Ticket;
import com.technoavi.cinetime.service.BookTicektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-ticket") // localhost:8080/book-ticket
//@CrossOrigin("*")
public class BookTicketController {

    @Autowired
    BookTicektService bookTicektService;

    @GetMapping("/msg") // localhost:8080/book-ticket/msg
    public String msg() {
        return "ready to place order!!";
    }

    @PostMapping("/save") // localhost:8080/book-ticket/save
    public Ticket saveTicket(@RequestBody Ticket order) {

        Ticket result = bookTicektService.bookTicket(order);
        return result;
    }

    @GetMapping("/getAll") // localhost:8080/book-ticket/getAll
    public List<Ticket> getAllOrder() {

        return bookTicektService.getAllTicekts();
    }

    @GetMapping("/getjson") // localhost:8080/book-ticket/getjson
    public Ticket getTicketById() {
        return new Ticket();
    }

    @GetMapping("/getTicket/{id}") // localhost:8080/book-ticket/getTicket/{id}
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") int id) {

        Ticket ticket = bookTicektService.getTicketById(id);
        if (ticket == null) {
            return new ResponseEntity<>(ticket, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/getname/{name}") // localhost:8080/book-ticket/getname/{name}
    public ResponseEntity<Ticket> getTicketByName(@PathVariable("name") String name) {

        Ticket response = bookTicektService.getTicketByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}") // localhost:8080/book-ticket/update/{id}
    public Ticket updateTicket(@PathVariable("id") int id, @RequestBody Ticket Ticket) {
        return bookTicektService.updateTicket(id, Ticket);
    }

    @DeleteMapping("/deletebyid/{id}") // localhost:8080/book-ticket/deletebyid/{id}
    public String deleteOrder(@PathVariable("id") int id) {
        return bookTicektService.deleteBooking(id);
    }
}
