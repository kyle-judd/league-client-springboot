package com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO;

public class ParticipantIdentityDTO {
    private int participantId;
    private PlayerDTO player;

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "ParticipantIdentityDTO{" +
                "participantId=" + participantId +
                ", player=" + player +
                '}';
    }
}
