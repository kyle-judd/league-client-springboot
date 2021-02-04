package com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO;

import java.util.List;

public class MatchTimelineDTO {
    private List<MatchFrameDTO> frames;
    private long frameInternal;

    public List<MatchFrameDTO> getFrames() {
        return frames;
    }

    public void setFrames(List<MatchFrameDTO> frames) {
        this.frames = frames;
    }

    public long getFrameInternal() {
        return frameInternal;
    }

    public void setFrameInternal(long frameInternal) {
        this.frameInternal = frameInternal;
    }

    @Override
    public String toString() {
        return "MatchTimelineDTO{" +
                "frames=" + frames +
                ", frameInternal=" + frameInternal +
                '}';
    }
}
