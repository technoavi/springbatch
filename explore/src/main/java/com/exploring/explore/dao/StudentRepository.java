package com.exploring.explore.dao;

import com.exploring.explore.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value="select * from exploring.table1 where name=:name", nativeQuery = true)
    Student getMedicineByName(@Param("name") String name);
}
