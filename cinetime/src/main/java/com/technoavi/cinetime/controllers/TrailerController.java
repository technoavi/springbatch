package com.technoavi.cinetime.controllers;

import com.technoavi.cinetime.dao.model.Trailer;
import com.technoavi.cinetime.service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trailer") // localhost:8080/trailer
public class TrailerController {
    @Autowired
    TrailerService trailerService;

    @PostMapping("/save") // localhost:8080/trailer/save
    public Trailer createTrailer(Trailer trailer) {
        return trailerService.createTrailer(trailer);
    }

    @GetMapping("/getall") // localhost:8080/trailer/getall
    public List<Trailer> getAllTrailers() {
        return trailerService.getAllTrailers();
    }

    @GetMapping("/getbyid/{id}") // localhost:8080/trailer/getbyid/{id}
    public Trailer getTrailerById(int id) {
        return trailerService.getTrailerById(id);
    }

    @GetMapping("/getbyname/{name}") // localhost:8080/trailer/getbyname/{name}
    public Trailer getTrailerByName(String name) {
        return trailerService.getTrailerByName(name);
    }

    @GetMapping("/updatebyid/{id}") // localhost:8080/trailer/updatebyid/{id}
    public Trailer updateTrailerById(int id, Trailer newTrailer) {
        return trailerService.updateTrailerById(id, newTrailer);
    }

//    public Trailer updateTrailerByName() {
//      trailerService
//    }

    @GetMapping("/deletebyid/{id}") // localhost:8080/trailer/deletebyid/{id}
    public String deleteTrailerById(int id) {
        trailerService.deleteTrailerById(id);
        return "Trailer deleted!!";
    }
}

