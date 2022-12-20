package com.technoavi.cinetime.dao.repositories;

import com.technoavi.cinetime.dao.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(value="select * from cinetimedb.ticket where movie_name=:name", nativeQuery = true)
    Ticket findByMovieName(@Param("name") String name);
}
