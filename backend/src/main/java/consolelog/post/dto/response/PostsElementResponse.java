package consolelog.post.dto.response;

import consolelog.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsElementResponse {
    private Long id;
    private String title;

    @Builder
    private PostsElementResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static PostsElementResponse from(Post post) {
        return PostsElementResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .build();
    }
}
