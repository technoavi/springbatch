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
    @Column(name = "movie_id")
    private int movieId;
    @Column(name = "movie_name")
    private String movie_name;
    @Column(name = "description")
    private String description;
    @Column(name = "actor")
    private String actor;
    @Column(name = "actress")
    private String actress;
    @Column(name = "rating")
    private String rating;
    @Column(name = "director")
    private String director;
    @Column(name = "release_date")
    private Date release_date;
}
