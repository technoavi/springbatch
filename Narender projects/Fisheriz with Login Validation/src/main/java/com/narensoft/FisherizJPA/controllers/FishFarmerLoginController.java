package com.narensoft.FisherizJPA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.narensoft.FisherizJPA.models.FishFarmerCredentials;
import com.narensoft.FisherizJPA.services.FishFarmerLoginService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FishFarmerLoginController {
	
	@Autowired
	private FishFarmerLoginService fishFarmerLoginService;
	
	@PostMapping("/login")
	public String validateLogin(@RequestBody FishFarmerCredentials fishFarmer) {
		if(fishFarmerLoginService.validateLogin(fishFarmer)) {
			return "Login Success";
		} else {
			return "Login Failed";
		}
	}
}