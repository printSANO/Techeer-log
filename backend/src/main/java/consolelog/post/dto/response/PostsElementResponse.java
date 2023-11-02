package consolelog.post.dto.response;

import consolelog.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsElementResponse {
    private Long id;
    private String title;
    private int viewCount;
    private int likeCount;

    @Builder
    private PostsElementResponse(Long id, String title, int viewCount, int likeCount) {
        this.id = id;
        this.title = title;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
    }

    public static PostsElementResponse from(Post post) {
        return PostsElementResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .viewCount(post.getViewCount())
                .likeCount(post.getLikeCount())
                .build();
    }
}
