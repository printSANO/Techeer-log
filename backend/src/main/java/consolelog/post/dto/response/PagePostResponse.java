package consolelog.post.dto.response;

import consolelog.post.domain.Post;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.stream.Collectors;

public class PagePostResponse {

    private List<PostsElementResponse> posts;

    public PagePostResponse(List<PostsElementResponse> posts) {
        this.posts = posts;
    }

    public static PagePostResponse of(Slice<Post> posts) {
        List<PostsElementResponse> postsElementResponses = posts.stream()
                .map(PostsElementResponse::from)
                .collect(Collectors.toList());
        return new PagePostResponse(postsElementResponses);
    }
}
