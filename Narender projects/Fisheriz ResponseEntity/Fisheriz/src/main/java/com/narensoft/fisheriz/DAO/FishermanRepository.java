package com.narensoft.fisheriz.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.narensoft.fisheriz.models.Fisherman;

@Repository
public interface FishermanRepository extends JpaRepository<Fisherman, Long>{

}
