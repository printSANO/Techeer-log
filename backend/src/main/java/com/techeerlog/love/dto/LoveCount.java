package com.techeerlog.love.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoveCount {
    private Long loveCount;
    private Long projectId;

    public LoveCount(Long loveCount, Long projectId) {
        this.loveCount = loveCount;
        this.projectId = projectId;
    }

}
