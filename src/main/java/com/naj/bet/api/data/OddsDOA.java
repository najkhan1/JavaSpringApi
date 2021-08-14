package com.naj.bet.api.data;

import com.naj.bet.api.models.Odds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OddsDOA extends JpaRepository<Odds, Long> {

    @Query("FROM Odds WHERE betId = :bet_id")
    public List<Odds> getOddsAllByID(@Param("bet_id") Long id);

    @Modifying
    @Query("update Odds set odds =  :newOdd where betId = :betId AND odds = :odds AND userId = :userId")
    public void updateOdd(@Param("betId") long id,@Param("odds") String odd,@Param("userId") String uId, @Param("newOdd") String newOdd);

    @Modifying
    @Query("delete from Odds where betId = :betId AND odds = :odds AND userId = :userId")
    public void deleteOdd(@Param("betId") long id,@Param("odds") String odd,@Param("userId") String uId);


    @Query("from Odds where betId = :betId AND odds = :odds AND userId = :userId")
    public Odds findOddByComp(@Param("betId") long id,@Param("odds") String odd,@Param("userId") String uId);
}
