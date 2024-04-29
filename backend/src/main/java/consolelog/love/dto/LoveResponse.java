package consolelog.love.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoveResponse {
    private Long loveId;
    private Long projectId;
    private Long memberId;

    public LoveResponse(Long loveId, Long projectId, Long memberId) {
        this.loveId = loveId;
        this.projectId = projectId;
        this.memberId = memberId;
    }
}
