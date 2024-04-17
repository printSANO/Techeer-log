package consolelog.scrap.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 사용자가 특정 프로젝트 스크랩할 때 사용
@Getter
@Setter
@NoArgsConstructor

public class ScrapRequest {
    private Long projectId;
    private Long memberId;

    public ScrapRequest(Long projectId, Long memberId) {
        this.projectId = projectId;
        this.memberId = memberId;
    }

}
