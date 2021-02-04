package com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO;

import java.util.List;

public class MatchlistDTO {
    private int startIndex;
    private int endIndex;
    private int totalGames;
    private List<MatchReferenceDTO> matches;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public List<MatchReferenceDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchReferenceDTO> matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        return "MatchlistDTO{" +
                "startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                ", totalGames=" + totalGames +
                ", matches=" + matches +
                '}';
    }
}
