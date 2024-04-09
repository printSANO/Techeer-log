package consolelog.post.dto;

import consolelog.post.domain.Post;
import lombok.Getter;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PagePostResponse {

    private final List<PostResponse> posts;
    private final Boolean lastPage;

    public PagePostResponse(List<PostResponse> posts, Boolean lastPage) {
        this.posts = posts;
        this.lastPage = lastPage;
    }

    public static PagePostResponse of(Slice<Post> posts) {
        List<PostResponse> postsResponses = posts.getContent()
                .stream()
                .map(PostResponse::from)
                .collect(Collectors.toList());
        return new PagePostResponse(postsResponses, posts.hasNext());
    }
}
