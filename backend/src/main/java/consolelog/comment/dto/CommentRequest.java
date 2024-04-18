package consolelog.comment.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Getter
@Setter
public class CommentRequest {
    @NotBlank(message = "댓글을 작성해주세요")
    private String content;
    private Long projectId;

}
