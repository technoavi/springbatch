package com.technoavi.cinetime.dao.repositories;

import com.technoavi.cinetime.dao.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, Integer> {
    @Query(value="select * from cinetimedb.movie where movie_name=:name", nativeQuery = true)
    Movie findByMovieName(@Param("name") String name);
}
