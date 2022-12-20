package com.technoavi.cinetime.dao.repositories;

import com.technoavi.cinetime.dao.model.Ticket;
import com.technoavi.cinetime.dao.model.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailerRepository  extends JpaRepository<Trailer, Integer> {
    @Query(value="select * from cinetimedb.trailer where movie_name=:name", nativeQuery = true)
    Trailer findByTrailerName(@Param("name") String name);
}
