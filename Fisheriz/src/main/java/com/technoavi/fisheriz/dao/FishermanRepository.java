package com.technoavi.fisheriz.dao;

import com.technoavi.fisheriz.models.FisherMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishermanRepository extends JpaRepository<FisherMan,Integer > {
}
