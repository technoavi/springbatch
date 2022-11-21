package com.narensoft.FisherizJPA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narensoft.FisherizJPA.DAO.FishFarmerCredentialsRepository;
import com.narensoft.FisherizJPA.models.FishFarmerCredentials;

@Service
public class FishFarmerLoginService {
	@Autowired
	FishFarmerCredentialsRepository fishFarmerCredentialsRepository;
	
	public boolean validateLogin(FishFarmerCredentials fishFarmerCredentials){
		String password = fishFarmerCredentials.getPassword();
		int id = fishFarmerCredentials.getId();
		
		try {
		
			if(fishFarmerCredentialsRepository.findPasswordById(id).equals(password)) {
				return true;
			} else {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
