package com.naj.bet.api.models;

import javax.persistence.*;

@Entity
@Table(name = "Odds")
@IdClass(OddsCompKey.class)
public class Odds {
    @Id
    @Column(name = "betId")
    private long betId;
    @Id
    @Column(name = "odds")
    private String odds;
    @Id
    @Column(name = "userId")
    private String userId;


    public Odds() {
    }

    public long getBetId() {
        return betId;
    }

    public void setBetId(long betId) {
        this.betId = betId;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
