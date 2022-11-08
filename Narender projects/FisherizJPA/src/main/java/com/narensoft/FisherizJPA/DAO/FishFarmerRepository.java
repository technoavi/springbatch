package com.narensoft.FisherizJPA.DAO;

import com.narensoft.FisherizJPA.models.FishFarmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishFarmerRepository extends JpaRepository<FishFarmer, Long> {
}
//Proxy Class - Auto Implemented