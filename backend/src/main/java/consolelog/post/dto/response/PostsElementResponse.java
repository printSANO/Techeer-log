package consolelog.post.dto.response;

import consolelog.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsElementResponse {
    private Long id;
    private String title;
    private String nickname;
    private int viewCount;
    private int likeCount;
    private int commentCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    private PostsElementResponse(Long id, String title, String nickname, int viewCount, int likeCount, int commentCount,
                                 LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.nickname = nickname;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    protected PostsElementResponse() {

    }

    public static PostsElementResponse from(Post post) {
        return PostsElementResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .nickname(post.getMember().getNickname())
                .viewCount(post.getViewCount())
                .likeCount(post.getLikeCount())
                .commentCount(post.getCommentCount())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}
