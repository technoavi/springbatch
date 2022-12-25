package com.technoavi.cinetime.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "trailer")
@Data
@JsonIgnoreProperties
public class Trailer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="trailer_id")
    int trailerId;
    @Column(name="movie_name")
    String movie_name;
    @Column(name="description")
    String  description;
    @Column(name="actor")
    String  actor;
    @Column(name="actress")
    String actress;
    @Column(name="director")
    String  director;
}
