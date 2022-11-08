package com.narensoft.FisherizJPA.services;

import com.narensoft.FisherizJPA.DAO.FishFarmerRepository;
import com.narensoft.FisherizJPA.models.FishFarmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FishFarmerService {

    @Autowired
    private FishFarmerRepository fishFarmerRepository;

    public Optional<FishFarmer> getFishFarmerById(long id) {
        return fishFarmerRepository.findById(id);
    }

    public FishFarmer createFishFarmer(FishFarmer fishFarmerData) {
        return fishFarmerRepository.save(fishFarmerData);
    }

    public FishFarmer updateFishFarmer(long id, FishFarmer fishFarmerUpdatedData) {
        if(fishFarmerRepository.findById(id).isPresent()) {
            FishFarmer fishFarmer = fishFarmerRepository.findById(id).get();
            fishFarmer.setName(fishFarmerUpdatedData.getName());
            fishFarmer.setAddress(fishFarmerUpdatedData.getAddress());
            fishFarmer.setWorkLocation(fishFarmerUpdatedData.getWorkLocation());
            fishFarmer.setPhone(fishFarmerUpdatedData.getPhone());
            return fishFarmerRepository.save(fishFarmer);
        }
        return null;
    }

    public List<FishFarmer> getAllFishFarmer() {
        return fishFarmerRepository.findAll();
    }

    public String deleteFishFarmer(long id) {
        if(fishFarmerRepository.findById(id).isPresent()) {
            fishFarmerRepository.deleteById(id);
            return "FishFarmer Deleted!";
        }
        return "Fish Farmer with id:" +id+" does not exist";
    }
}
