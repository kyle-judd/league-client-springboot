package com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO;

public class AccountDTO {
    private String puuid;
    private String gameName;
    private String tagline;

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "puuid='" + puuid + '\'' +
                ", gameName='" + gameName + '\'' +
                ", tagline='" + tagline + '\'' +
                '}';
    }
}
