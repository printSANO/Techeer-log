package consolelog.project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ProjectRequest {
    @NotBlank(message = "제목을 입력해주세요.")
    private String title;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;
    private String mainImageUrl;

    public ProjectRequest() {
    }

    public ProjectRequest(String title, String content, String mainImageUrl) {
        this.title = title;
        this.content = content;
        this.mainImageUrl = mainImageUrl;
    }
}
