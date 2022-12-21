package com.technoavi.cinetime.controllers;

import com.technoavi.cinetime.dao.model.TrendingShow;
import com.technoavi.cinetime.service.TrendingShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trendingshows") // localhost:8080/trendingshows
public class TrendingShowsController {
    @Autowired
    TrendingShowService trendingShowService;

    @PostMapping("/save") // localhost:8080/trendingshows/save
    public TrendingShow createTrendingShow(@RequestBody TrendingShow trendingShow) {
        return trendingShowService.createTrendingShow(trendingShow);
    }

    @GetMapping("/getall") // localhost:8080/trendingshows/getall
    public List<TrendingShow> getAllTrendingShows() {
        return trendingShowService.getAllTrendingShows();
    }

    @GetMapping("/getjson") // localhost:8080/trendingshows/getjson
    public TrendingShow getTrendingShowJson() {
        return trendingShowService.getTrendingShowJson();
    }

    @GetMapping("/getbyid/{id}") // localhost:8080/trendingshows/getbyid/{id}
    public TrendingShow getTrendingShowById(@PathVariable int id) {
        return trendingShowService.getTrendingShowById(id);
    }

    @GetMapping("/getbyname/{name}") // localhost:8080/trendingshows/getbyname/{name}
    public TrendingShow getTrendingShowByName(@PathVariable String name) {
        return trendingShowService.getTrendingShowByName(name);
    }


    @PutMapping("updatebyid/{id}") // localhost:8080/trendingshows/updatebyid/{id}
    public TrendingShow updateTrendingShowById(@PathVariable int id, @RequestBody TrendingShow newTrendingShow) {
        return trendingShowService.updateTrendingShowById(id, newTrendingShow);
    }

//    public TrendingShow updateTrendingShowByName() {
//      trendingShowService
//    }

    @DeleteMapping("/deletebyid/{id}") // localhost:8080/trendingshows/deletebyid/{id}
    public String deleteTrendingShowById(@PathVariable int id) {
        trendingShowService.deleteTrendingShowById(id);
        return "TrendingShow deleted!!";
    }
}
