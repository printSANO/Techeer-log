package consolelog.post.dto.response;

import consolelog.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponse {
    private Long id;
    private String title;
    private String content;
    private String nickname;
    private int likeCount;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BoardResponse() {
    }

    @Builder
    private BoardResponse(Long id, String title, String content, String nickname, int likeCount, int viewCount,
                          LocalDateTime createdAt, LocalDateTime updatedAt) { //생성자 주입, 초기화
        this.id = id;
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // of 메소드를 통해 FindPostResponse 객체를 생성
    public static BoardResponse of(Post post) {
        return BoardResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .nickname(post.getMember().getNickname())
                .viewCount(post.getViewCount())
                .likeCount(post.getLikeCount())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}
