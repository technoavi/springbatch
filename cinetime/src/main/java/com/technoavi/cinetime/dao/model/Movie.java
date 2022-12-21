package com.technoavi.cinetime.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie")
@Data
@JsonIgnoreProperties
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    @Column(name = "movie_name")
    String movie_name;
    @Column(name = "description")
    String description;
    @Column(name = "actor")
    String actor;
    @Column(name = "actress")
    String actress;
    @Column(name = "rating")
    String rating;
    @Column(name = "director")
    String director;
    @Column(name = "release_date")
    Date release_date;
}
