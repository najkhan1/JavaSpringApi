package com.naj.bet.api.models;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class OddsCompKey implements Serializable {

    @Column(name = "betId")
    private long betId;
    @Column(name = "odds")
    private String odds;
    @Column(name = "userId")
    private String userId;


    public OddsCompKey() {
    }

    public OddsCompKey(long betId, String odds, String userId) {
        this.betId = betId;
        this.odds = odds;
        this.userId = userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OddsCompKey oddsCompKey = (OddsCompKey) o;
        return betId == oddsCompKey.betId &&
                odds.equals(oddsCompKey.odds) && userId.equals(oddsCompKey.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(betId, odds,userId);
    }
}
