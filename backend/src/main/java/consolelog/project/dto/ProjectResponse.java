package consolelog.project.dto;

import consolelog.project.domain.Project;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProjectResponse {
    private Long id;
    private String title;
    private String content;
    private String mainImageUrl;
    private String nickname;
    private String profileImageUrl;
    private int likeCount;
    private int viewCount;
    private int commentCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProjectResponse() {
    }

    @Builder
    private ProjectResponse(Long id, String title, String content, String mainImageUrl, String nickname,
                            String profileImageUrl, int likeCount, int viewCount, int commentCount,
                            LocalDateTime createdAt, LocalDateTime updatedAt) { //생성자 주입, 초기화
        this.id = id;
        this.title = title;
        this.content = content;
        this.mainImageUrl = mainImageUrl;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // of 메소드를 통해 FindPostResponse 객체를 생성
    public static ProjectResponse from(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .content(project.getContent())
                .mainImageUrl(project.getMainImageUrl())
                .nickname(project.getMember().getNickname())
                .profileImageUrl(project.getMember().getProfileImageUrl())
                .viewCount(project.getViewCount())
                .likeCount(project.getLikeCount())
                .commentCount(project.getCommentCount())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .build();
    }
}
