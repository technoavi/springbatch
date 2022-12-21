package com.technoavi.cinetime.service;

import com.technoavi.cinetime.dao.model.Trailer;
import com.technoavi.cinetime.dao.repositories.TrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrailerService {
    @Autowired
    TrailerRepository trailerRepository;

    public Trailer createTrailer(Trailer trailer) {
        return trailerRepository.save(trailer);
    }

    public List<Trailer> getAllTrailers() {
        return trailerRepository.findAll();
    }

    public Trailer getTrailerJson() {
        return new Trailer();
    }
    public Trailer getTrailerById(int id) {
        return trailerRepository.findById(id).get();
    }

    public Trailer getTrailerByName(String name) {
        return trailerRepository.findByTrailerName(name);
    }

    private Trailer copyTrailer(Trailer oldTrailer, Trailer newTrailer) {
        oldTrailer.setMovie_name(newTrailer.getMovie_name());
        oldTrailer.setActor(newTrailer.getActor());
        oldTrailer.setActress(newTrailer.getActress());
        oldTrailer.setDirector(newTrailer.getDirector());
        oldTrailer.setDescription(newTrailer.getDescription());

        return oldTrailer;
    }

    public Trailer updateTrailerById(int id, Trailer newTrailer) {
        Trailer oldTrailer = trailerRepository.findById(id).get();
        return trailerRepository.save(copyTrailer(oldTrailer, newTrailer));
    }

//    public Trailer updateTrailerByName() {
//      trailerRepository
//    }

    public String deleteTrailerById(int id) {
        trailerRepository.deleteById(id);
        return "Trailer deleted!!";
    }

}
