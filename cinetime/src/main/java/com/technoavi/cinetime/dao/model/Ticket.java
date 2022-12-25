package com.technoavi.cinetime.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
@Data
@JsonIgnoreProperties
public class Ticket {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ticket_id")
    private Integer ticketId;
    @Column(name="price")
    private float price;
    @Column(name="no_of_ticket")
    private int noOfTickets;
    @Column(name="date")
    private Date date;
    @Column(name="location")
    private String location;
    @Column(name="seat_no")
    private int seatNo;
    @Column(name="movie_name")
    private String movieName;
    @Column(name="screen_name")
    private String screenName;
    @Column(name="status")
    private boolean status;
}
