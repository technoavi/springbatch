package com.technoavi.medico.dao;

import com.technoavi.medico.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    @Query(value="select * from medical_store.medicine where name=:name", nativeQuery = true)
    Medicine getMedicineByName(@Param("name") String name);
}
