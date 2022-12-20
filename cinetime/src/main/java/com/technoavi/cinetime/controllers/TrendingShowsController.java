package com.technoavi.cinetime.controllers;

import com.technoavi.cinetime.dao.model.TrendingShow;
import com.technoavi.cinetime.service.TrendingShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trendingshows") // localhost:8080/trendingshows
public class TrendingShowsController {
    @Autowired
    TrendingShowService trendingShowService;

    @PostMapping("/save") // localhost:8080/trendingshows/save
    public TrendingShow createTrendingShow(TrendingShow trendingShow) {
        return trendingShowService.createTrendingShow(trendingShow);
    }

    @GetMapping("/getall") // localhost:8080/trendingshows/getall
    public List<TrendingShow> getAllTrendingShows() {
        return trendingShowService.getAllTrendingShows();
    }

    @GetMapping("/getbyid/{id}") // localhost:8080/trendingshows/getbyid/{id}
    public TrendingShow getTrendingShowById(int id) {
        return trendingShowService.getTrendingShowById(id);
    }

    @GetMapping("/getbyname/{name}") // localhost:8080/trendingshows/getbyname/{name}
    public TrendingShow getTrendingShowByName(String name) {
        return trendingShowService.getTrendingShowByName(name);
    }


    @GetMapping("updatebyid/{id}") // localhost:8080/trendingshowsupdatebyid/{id}
    public TrendingShow updateTrendingShowById(int id, TrendingShow newTrendingShow) {
        return trendingShowService.updateTrendingShowById(id, newTrendingShow);
    }

//    public TrendingShow updateTrendingShowByName() {
//      trendingShowService
//    }

    @GetMapping("/deletebyid/{id}") // localhost:8080/trendingshows/deletebyid/{id}
    public String deleteTrendingShowById(int id) {
        trendingShowService.deleteTrendingShowById(id);
        return "TrendingShow deleted!!";
    }
}
