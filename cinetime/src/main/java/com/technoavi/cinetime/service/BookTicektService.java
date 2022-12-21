package com.technoavi.cinetime.service;

import com.technoavi.cinetime.dao.model.Ticket;
import com.technoavi.cinetime.dao.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookTicektService {

    @Autowired
    TicketRepository ticketRepository;

    public Ticket bookTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTicekts() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id).get();
    }

    public Ticket getTicketByName(String name) {
        return ticketRepository.findByMovieName(name);

    }

    public Ticket updateTicket(int id, Ticket ticket) {
        Optional<Ticket> meds =   ticketRepository.findById(id);
        Ticket ticket_res=meds.get();

        ticket_res.setNoOfTickets(ticket.getNoOfTickets());
        ticket_res.setTicketId(ticket.getTicketId());
        ticket_res.setDate(ticket.getDate());
        ticket_res.setLocation(ticket.getLocation());
        ticket_res.setPrice(ticket.getPrice());
        ticket_res.setStatus(ticket.isStatus());
        ticket_res.setMovieName(ticket.getMovieName());
        ticket_res.setSeatNo(ticket.getSeatNo());
        ticket_res.setPrice(ticket.getPrice());
        ticket_res.setScreenName(ticket.getScreenName());

        //  listOfOrders.add(id,upOrder);
        return   ticketRepository.save(ticket_res);

    }

    public String deleteBooking(int id) {
        ticketRepository.deleteById(id);
        return "Your Ticket has been cancelled!!";
    }
}
