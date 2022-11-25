package com.technoavi.medico.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name="medicine")
@JsonIgnoreProperties
public class Medicine {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long  id ;

    @Column(name="name")
    String name  ;
    @Column(name="price")
    long price  ;
    @Column(name="expiry_date")
    Date expiryDate ;
    @Column(name="composition")
    String composition  ;
    @Column(name="dosage")
    String dosage      ;
    @Column(name="quantity")
    long  quantity   ;



}
