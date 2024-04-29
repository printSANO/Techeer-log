package consolelog.scrap.dto;

import consolelog.project.domain.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 사용자가 마이페이지에서 스크랩한 프로젝트 리스트를 보여줄 때 사용될 정보 포함해야 됨
@Getter
@Setter
@NoArgsConstructor
public class ScrapResponse {
    private Long scrapId;
    private Long projectId;
    private Long memberId;
    private boolean isScraped;

    public ScrapResponse(Long scrapId, Long projectId, Long memberId, boolean isScraped) {
        this.scrapId = scrapId;
        this.projectId = projectId;
        this.memberId = memberId;
        this.isScraped = isScraped;
    }

}
