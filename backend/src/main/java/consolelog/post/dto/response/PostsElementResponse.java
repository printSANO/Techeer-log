package consolelog.post.dto.response;

import consolelog.post.domain.Post;
import lombok.Builder;

@Builder
public class PostsElementResponse {
    private Long id;
    private String title;

    public static PostsElementResponse from(Post post) {
        return PostsElementResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .build();
    }
}
