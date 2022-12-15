package com.springBootDAO.collegeAdmin.collegeAdminDAO.DAO;

import com.springBootDAO.collegeAdmin.collegeAdminDAO.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select * from collegeAdminDAO.student where name=:name", nativeQuery = true)
    Student getStudentByName(@Param("name") String name);
}
