package consolelog.post.dto.response;

import consolelog.post.domain.Post;
import lombok.Getter;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PagePostResponse {

    private List<PostsElementResponse> posts;
    private Boolean lastpage;

    public PagePostResponse(List<PostsElementResponse> posts, Boolean lastpage) {
        this.posts = posts;
        this.lastpage = lastpage;
    }

    public static PagePostResponse of(Slice<Post> posts) {
        List<PostsElementResponse> postsElementResponses = posts.getContent()
                .stream()
                .map(PostsElementResponse::from)
                .collect(Collectors.toList());
        return new PagePostResponse(postsElementResponses, posts.hasNext());
    }
}
