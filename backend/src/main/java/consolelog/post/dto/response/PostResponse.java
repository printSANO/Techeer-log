package consolelog.post.dto.response;

import consolelog.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private String nickname;
    private int likeCount;
    private int viewCount;
    private int commentCount;
    private boolean like;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @Builder
    private PostResponse(Long id, String title, String content, String nickname,
                         int likeCount, int viewCount, int commentCount, boolean like,
                         LocalDateTime createdAt, LocalDateTime updatedAt) { //생성자 주입, 초기화
        this.id = id;
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.like = like;


    }

    // of 메소드를 통해 FindPostResponse 객체를 생성
    public static PostResponse of(Post post, boolean liked) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .nickname(post.getMember().getNickname())
                .likeCount(post.getLikeCount())
                .viewCount(post.getViewCount())
                .commentCount(post.getCommentCount())
                .like(liked)
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}
