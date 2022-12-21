package com.technoavi.cinetime.service;

import com.technoavi.cinetime.dao.model.TrendingShow;
import com.technoavi.cinetime.dao.repositories.TrendingShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrendingShowService {
    @Autowired
    TrendingShowRepository trendingShowRepository;

    public TrendingShow createTrendingShow(TrendingShow trendingShow) {
        return trendingShowRepository.save(trendingShow);
    }

    public List<TrendingShow> getAllTrendingShows() {
        return trendingShowRepository.findAll();
    }

    public TrendingShow getTrendingShowJson() {
        return new TrendingShow();
    }
    public TrendingShow getTrendingShowById(int id) {
        return trendingShowRepository.findById(id).get();
    }

    public TrendingShow getTrendingShowByName(String name) {
        return trendingShowRepository.findByMovieName(name);
    }

    private TrendingShow copyTrendingShow(TrendingShow oldTrendingShow, TrendingShow newTrendingShow) {
        oldTrendingShow.setMovie_name(newTrendingShow.getMovie_name());
        oldTrendingShow.setRating(newTrendingShow.getRating());

        return oldTrendingShow;
    }

    public TrendingShow updateTrendingShowById(int id, TrendingShow newTrendingShow) {
        TrendingShow oldTrendingShow = trendingShowRepository.findById(id).get();
        return trendingShowRepository.save(copyTrendingShow(oldTrendingShow, newTrendingShow));
    }

//    public TrendingShow updateTrendingShowByName() {
//      trendingShowRepository
//    }

    public String deleteTrendingShowById(int id) {
        trendingShowRepository.deleteById(id);
        return "TrendingShow deleted!!";
    }
}
