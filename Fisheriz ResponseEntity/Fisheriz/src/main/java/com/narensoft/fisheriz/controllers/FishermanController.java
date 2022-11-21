package com.narensoft.fisheriz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.narensoft.fisheriz.models.Fisherman;
import com.narensoft.fisheriz.services.FishermanService;


//Validation
@RestController
@RequestMapping("/fisherman")
public class FishermanController {
	
	@Autowired
	private FishermanService fishermanService;
	
	@PostMapping("/create")
	public Fisherman createFisherman(@RequestBody Fisherman fisherman) {
		return fishermanService.createFisherman(fisherman);
	}
	
	@PostMapping("/update/{id}")
	public Fisherman updateFisherman(@PathVariable(value = "id") long fishermanId,
			@RequestBody Fisherman updatedFisherman) {
		return fishermanService.updateFisherman(fishermanId, updatedFisherman);
	}
	
	@GetMapping("/getById/{id}")
	public Fisherman getFishermanById(@PathVariable(value = "id") long fishermanId) {
		return fishermanService.getFishermanById(fishermanId);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteFisherman(@PathVariable(value = "id") long fishermanId) {
		fishermanService.deleteFisherman(fishermanId);
	}
	
	@GetMapping("/getAll")
	public List<Fisherman> getAllFisherman() {
		return fishermanService.getAllFisherman();
	}
}
