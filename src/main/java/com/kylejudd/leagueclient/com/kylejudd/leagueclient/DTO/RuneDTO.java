package com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO;

public class RuneDTO {
    private int runeId;
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRuneId() {
        return runeId;
    }

    public void setRuneId(int runeId) {
        this.runeId = runeId;
    }

    @Override
    public String toString() {
        return "RuneDTO{" +
                "runeId=" + runeId +
                ", rank=" + rank +
                '}';
    }
}
