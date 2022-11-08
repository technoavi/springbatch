package com.narensoft.FisherizJPA.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FishFarmerCredentials {
	@Id
	private int id;
	private String password;
	
	public FishFarmerCredentials() {
	}
	
	public FishFarmerCredentials(int id, String password) {
		this.id = id;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}
