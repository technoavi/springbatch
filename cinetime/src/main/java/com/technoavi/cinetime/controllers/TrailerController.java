package com.technoavi.cinetime.controllers;

import com.technoavi.cinetime.dao.model.Trailer;
import com.technoavi.cinetime.service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trailer") // localhost:8080/trailer
public class TrailerController {
    @Autowired
    TrailerService trailerService;

    @PostMapping("/save") // localhost:8080/trailer/save
    public Trailer createTrailer(@RequestBody Trailer trailer) {
        return trailerService.createTrailer(trailer);
    }

    @GetMapping("/getall") // localhost:8080/trailer/getall
    public List<Trailer> getAllTrailers() {
        return trailerService.getAllTrailers();
    }

    @GetMapping("/getjson") // localhost:8080/trailer/getjson
    public Trailer getTrailerJson() {
        return trailerService.getTrailerJson();
    }

    @GetMapping("/getbyid/{id}") // localhost:8080/trailer/getbyid/{id}
    public Trailer getTrailerById(@PathVariable int id) {
        return trailerService.getTrailerById(id);
    }

    @GetMapping("/getbyname/{name}") // localhost:8080/trailer/getbyname/{name}
    public Trailer getTrailerByName(@PathVariable String name) {
        return trailerService.getTrailerByName(name);
    }

    @PutMapping("/updatebyid/{id}") // localhost:8080/trailer/updatebyid/{id}
    public Trailer updateTrailerById(@PathVariable int id, @RequestBody Trailer newTrailer) {
        return trailerService.updateTrailerById(id, newTrailer);
    }

//    public Trailer updateTrailerByName() {
//      trailerService
//    }

    @DeleteMapping("/deletebyid/{id}") // localhost:8080/trailer/deletebyid/{id}
    public String deleteTrailerById(@PathVariable int id) {
        trailerService.deleteTrailerById(id);
        return "Trailer deleted!!";
    }
}

