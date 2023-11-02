package consolelog.post.dto.response;

import consolelog.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponse {
    private Long id;
    private String title;
    private String content;
    private int viewCount;


    @Builder
    private BoardResponse(Long id, String title, String content, int viewCount) { //생성자 주입, 초기화
        this.id = id;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;

    }

    // of 메소드를 통해 FindPostResponse 객체를 생성
    public static BoardResponse of(Post post) {
        return BoardResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .viewCount(post.getViewCount())
                .build();
    }
}
