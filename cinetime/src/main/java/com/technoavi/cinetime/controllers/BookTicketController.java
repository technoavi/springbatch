package com.technoavi.cinetime.controllers;


import com.technoavi.cinetime.dao.model.Ticket;
import com.technoavi.cinetime.service.BookTicektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-ticket")
@CrossOrigin("*")
public class BookTicketController {

    @Autowired
    BookTicektService bookTicektService;

    @GetMapping("/msg")
    public String msg() {
        return "ready to place order!!";
    }

    @PostMapping("/save")
    public Ticket saveTicket(@RequestBody Ticket order) {

        Ticket result = bookTicektService.bookTicket(order);
        return result;
    }

    @GetMapping("/getAll")
    public List<Ticket> getAllOrder() {

        return bookTicektService.getAllTicekts();
    }

    @GetMapping("/getTicket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") int id) {

        Ticket ticket = bookTicektService.getTicketById(id);
        if (ticket == null) {
            return new ResponseEntity<>(ticket, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/getname/{name}")
    public ResponseEntity<Ticket> getTicketByName(@PathVariable("name") String name) {

        Ticket response = bookTicektService.getTicketByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public Ticket updateTicket(@PathVariable("id") int id, @RequestBody Ticket Ticket) {
        return bookTicektService.updateTicket(id, Ticket);
    }

    @DeleteMapping("/delete/{oderId}")
    public String deleteOrder(@PathVariable("oderId") int id) {
        return bookTicektService.deleteBooking(id);
    }
}
