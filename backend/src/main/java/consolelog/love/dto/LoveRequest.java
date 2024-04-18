package consolelog.love.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoveRequest {
    private Long projectId;
    private Long memberId;

    public LoveRequest(Long projectId, Long memberId) {
        this.projectId = projectId;
        this.memberId = memberId;
    }
}
