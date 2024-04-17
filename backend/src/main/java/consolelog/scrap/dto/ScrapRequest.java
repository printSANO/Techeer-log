package consolelog.scrap.dto;

import lombok.Getter;
import lombok.Setter;

// 사용자가 특정 프로젝트 스크랩할 때 사용
@Getter
@Setter
public class ScrapRequest {
    private Long projectId;

    public ScrapRequest() {
    }

    public ScrapRequest(Long projectId) {
        this.projectId = projectId;
    }
}
