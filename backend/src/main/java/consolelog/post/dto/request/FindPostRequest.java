package consolelog.post.dto.request;

import lombok.Getter;

@Getter
public class FindPostRequest {
    private Long id;
//    private String title;

    public FindPostRequest(Long id) {
        this.id = id;
    }
}
