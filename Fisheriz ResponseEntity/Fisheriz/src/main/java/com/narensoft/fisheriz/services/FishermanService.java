package com.narensoft.fisheriz.services;

import java.util.List;

import org.apache.catalina.LifecycleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narensoft.fisheriz.DAO.FishermanRepository;
import com.narensoft.fisheriz.models.Fisherman;


@Service
public class FishermanService {

	@Autowired
	private FishermanRepository fishermanRepository;
	
	public Fisherman createFisherman(Fisherman fisherman) {
		return fishermanRepository.save(fisherman);
	}
	
	public Fisherman updateFisherman(long fishermanId, Fisherman updatedFisherman) {
		Fisherman fisherman = fishermanRepository.findById(fishermanId).get();
		
		
		fisherman.setUsername(updatedFisherman.getUsername());
		fisherman.setName(updatedFisherman.getName());
		fisherman.setAddress(updatedFisherman.getAddress());
		
		fishermanRepository.save(fisherman);
		
		return fisherman;
	}
	
	public Fisherman getFishermanById(long fishermanId) {
		if(fishermanRepository.findById(fishermanId).isPresent()) {
		   return fishermanRepository.findById(fishermanId).get();
		} else {
			return null;
		}
	}
	
	public void deleteFisherman(long fishermanId) {
		fishermanRepository.deleteById(fishermanId);
	}
	
	public List<Fisherman> getAllFisherman() {
		return fishermanRepository.findAll();
	}
}
