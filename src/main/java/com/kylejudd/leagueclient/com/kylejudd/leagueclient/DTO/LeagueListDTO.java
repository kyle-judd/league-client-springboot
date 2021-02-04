package com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO;

import java.util.List;

public class LeagueListDTO {
    private String leagueId;
    private List<LeagueItemDTO> entries;
    private String tier;
    private String name;
    private String queue;

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public List<LeagueItemDTO> getEntries() {
        return entries;
    }

    public void setEntries(List<LeagueItemDTO> entries) {
        this.entries = entries;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "LeagueListDTO{" +
                "leagueId='" + leagueId + '\'' +
                ", entries=" + entries +
                ", tier='" + tier + '\'' +
                ", name='" + name + '\'' +
                ", queue='" + queue + '\'' +
                '}';
    }
}
