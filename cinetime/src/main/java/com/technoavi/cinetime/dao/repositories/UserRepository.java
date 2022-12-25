package com.technoavi.cinetime.dao.repositories;

import com.technoavi.cinetime.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from cinetimedb.user where name=:name", nativeQuery = true)
    public User findByName(@Param("name") String name);
    @Query(value = "select * from cinetimedb.user where user_id=:username", nativeQuery = true)
    public User findByUserName(@Param("username") String username);

}
