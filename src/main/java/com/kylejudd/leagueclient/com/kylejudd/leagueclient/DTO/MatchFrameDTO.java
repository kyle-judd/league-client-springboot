package com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO;

import java.util.List;
import java.util.Map;

public class MatchFrameDTO {
    private Map<String, MatchParticipantFrameDTO> participantFrames;
    private List<MatchEventDTO> events;
    private long timestamp;

    public Map<String, MatchParticipantFrameDTO> getParticipantFrames() {
        return participantFrames;
    }

    public void setParticipantFrames(Map<String, MatchParticipantFrameDTO> participantFrames) {
        this.participantFrames = participantFrames;
    }

    public List<MatchEventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<MatchEventDTO> events) {
        this.events = events;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MatchFrameDTO{" +
                "participantFrames=" + participantFrames +
                ", events=" + events +
                ", timestamp=" + timestamp +
                '}';
    }
}
