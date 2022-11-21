package com.technoavi.fisheriz.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;


//@Table(name="fihser_man")
@Data
@Entity
public class FisherMan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    private String name;
    @ApiModelProperty(
            value = "address of the fisher man",
            name = "address",
            dataType = "String",
            example = "Hubli")
    private String address;
    @ApiModelProperty(notes = "Work Location name", example = "Kolkata", required = false)
    private String workLocation;
    private long mobile;
}
