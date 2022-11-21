package com.narensoft.FisherizJPA.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.narensoft.FisherizJPA.models.FishFarmerCredentials;

@Repository
public interface FishFarmerCredentialsRepository extends JpaRepository<FishFarmerCredentials, Integer>{
	
    @Query("SELECT f.password FROM FishFarmerCredentials f WHERE f.id=?1") 
	public String findPasswordById(int id);
}
