package com.technoavi.cinetime.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "trending_show")
@Data
@JsonIgnoreProperties
public class TrendingShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trending_show_id")
    int trendingShowId;
    @Column(name="movie_name")
    String movie_name;
    @Column(name="rating")
    String rating;
}
