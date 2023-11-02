package consolelog.post.dto.response;

import consolelog.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private int likeCount;
    private int viewCount;
    private boolean like;


    @Builder
    private PostResponse(Long id, String title, String content, int likeCount, int viewCount, boolean like) { //생성자 주입, 초기화
        this.id = id;
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.like = like;

    }

    // of 메소드를 통해 FindPostResponse 객체를 생성
    public static PostResponse of(Post post, boolean liked) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .likeCount(post.getLikeCount())
                .viewCount(post.getViewCount())
                .like(liked)
                .build();
    }
}
