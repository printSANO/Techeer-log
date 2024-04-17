package consolelog.scrap.dto;

import consolelog.project.domain.Project;
import lombok.Getter;
import lombok.Setter;

// 사용자가 마이페이지에서 스크랩한 프로젝트 리스트를 보여줄 때 사용될 정보 포함해야 됨
@Getter
@Setter
public class ScrapResponse {
    private Long scrapId;
    private Long projectId;
    private String mainImageUrl;
    private String title;
    private String subtitle;

    public ScrapResponse(Long scrapId, Long projectId, String mainImageUrl, String title, String subtitle) {
        this.scrapId = scrapId;
        this.projectId = projectId;
        this.mainImageUrl = mainImageUrl;
        this.title = title;
        this.subtitle = subtitle;
    }


}
