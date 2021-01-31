package com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO;

import java.util.List;


public class MatchDTO {
    private long gameId;
    private List<ParticipantIdentityDTO> participantIdentities;
    private int queueId;
    private String gameType;
    private List<TeamStatsDTO> teams;
    private String platformId;
    private long gameCreation;
    private int seasonId;
    private int mapId;
    private String gameMode;
    private List<ParticipantDTO> participants;

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public List<ParticipantIdentityDTO> getParticipantIdentities() {
        return participantIdentities;
    }

    public void setParticipantIdentities(List<ParticipantIdentityDTO> participantIdentities) {
        this.participantIdentities = participantIdentities;
    }

    public int getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public List<TeamStatsDTO> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamStatsDTO> teams) {
        this.teams = teams;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public long getGameCreation() {
        return gameCreation;
    }

    public void setGameCreation(long gameCreation) {
        this.gameCreation = gameCreation;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public List<ParticipantDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDTO> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "MatchDTO{" +
                "gameId=" + gameId +
                ", participantIdentities=" + participantIdentities +
                ", queueId=" + queueId +
                ", gameType='" + gameType + '\'' +
                ", teams=" + teams +
                ", platformId='" + platformId + '\'' +
                ", gameCreation=" + gameCreation +
                ", seasonId=" + seasonId +
                ", mapId=" + mapId +
                ", gameMode='" + gameMode + '\'' +
                ", participants=" + participants +
                '}';
    }
}
