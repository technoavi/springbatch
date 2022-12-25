package com.technoavi.cinetime.dao.repositories;

import com.technoavi.cinetime.dao.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {
    @Query(value = "select * from cinetimedb.user_credential where name=:name", nativeQuery = true)
    public UserCredential findByName(@Param("name") String name);

    @Query(value = "select * from cinetimedb.user_credential where user_id=:username", nativeQuery = true)
    public UserCredential findByUserName(@Param("username") String userName);
}