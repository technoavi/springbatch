package com.narensoft.FisherizJPA.controllers;

import com.narensoft.FisherizJPA.models.FishFarmer;
import com.narensoft.FisherizJPA.services.FishFarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ff")
public class FishFarmerController {

    @Autowired
    private FishFarmerService fishFarmerService;

    @PostMapping("/createff")
    FishFarmer createFishFarmer(@RequestBody FishFarmer fishFarmerData){
        return fishFarmerService.createFishFarmer(fishFarmerData);
    }

    @GetMapping("/getffbyid/{id}")
    Optional<FishFarmer> getFishFarmerById(@PathVariable long id) {
            return fishFarmerService.getFishFarmerById(id);
    }

    @PostMapping("/updateff/{id}")
    FishFarmer updateFishFarmer(@PathVariable long id,@RequestBody FishFarmer fishFarmerUpdatedData){
            return fishFarmerService.updateFishFarmer(id, fishFarmerUpdatedData);
    }
    @GetMapping("/getallff")
    List<FishFarmer> getAllFishFarmer(){
            return fishFarmerService.getAllFishFarmer();
    }

    @GetMapping("/deleteff/{id}")
    String deleteFishFarmer(@PathVariable long id){
        return fishFarmerService.deleteFishFarmer(id);
    }

}
