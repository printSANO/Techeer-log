package consolelog.comment.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class NewCommentRequest {

    @NotBlank(message = "댓글을 입력해주세요.")
    private String content;

    public NewCommentRequest() {
    }

    public NewCommentRequest(String content) {
        this.content = content;
    }
}
