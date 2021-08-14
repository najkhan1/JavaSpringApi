package com.naj.bet.api.models;

public class OddsUpdateObj {
    private long betId;
    private String odds;
    private String userId;
    private String newOdd;

    public OddsUpdateObj() {
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

    public String getNewOdd() {
        return newOdd;
    }

    public void setNewOdd(String newOdd) {
        this.newOdd = newOdd;
    }
}
