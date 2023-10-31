package consolelog.post.dto.response;

import consolelog.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    // private Boolean authorized;
//    private Long like_count;
//    private Long view_count;
    // private String created_at;

    @Builder
    private PostResponse(Long id, String title, String content) { //생성자 주입, 초기화
        this.id = id;
        this.title = title;
        this.content = content;
        //this.authorized = authorized;
//        this.like_count = like_count;
//        this.view_count = view_count;
        //this.created_at = created_at;
    }

    // of 메소드를 통해 FindPostResponse 객체를 생성
    public static PostResponse of(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
