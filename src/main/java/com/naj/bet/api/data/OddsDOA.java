package com.naj.bet.api.data;

import com.naj.bet.api.models.Odds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OddsDOA extends JpaRepository<Odds, Long> {

    @Query("FROM Odds WHERE betId = :bet_id")
    public List<Odds> getOddsAllByID(@Param("bet_id") Long id);
}
