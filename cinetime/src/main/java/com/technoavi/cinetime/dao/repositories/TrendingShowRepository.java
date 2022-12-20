package com.technoavi.cinetime.dao.repositories;

import com.technoavi.cinetime.dao.model.Trailer;
import com.technoavi.cinetime.dao.model.TrendingShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendingShowRepository  extends JpaRepository<TrendingShow, Integer> {
    @Query(value="select * from cinetimedb.trending_show where movie_name=:name", nativeQuery = true)
    TrendingShow findByMovieName(@Param("name") String name);
}
