package com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO;

public class MasteryDTO {
    private int rank;
    private int masteryId;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getMasteryId() {
        return masteryId;
    }

    public void setMasteryId(int masteryId) {
        this.masteryId = masteryId;
    }

    @Override
    public String toString() {
        return "MasteryDTO{" +
                "rank=" + rank +
                ", masteryId=" + masteryId +
                '}';
    }
}
