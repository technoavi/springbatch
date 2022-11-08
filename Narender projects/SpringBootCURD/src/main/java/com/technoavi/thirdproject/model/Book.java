package com.technoavi.thirdproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="book")
@JsonIgnoreProperties
public class Book {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long  id ;
  private String tiTle;
  private String author;
  private String genre;


}
