package consolelog.project.dto;

import consolelog.project.domain.Project;
import lombok.Getter;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PagePostResponse {

    private final List<ProjectResponse> posts;
    private final Boolean lastPage;

    public PagePostResponse(List<ProjectResponse> posts, Boolean lastPage) {
        this.posts = posts;
        this.lastPage = lastPage;
    }

//    public static PagePostResponse of(Slice<Project> posts) {
//        List<ProjectResponse> postsResponses = posts.getContent()
//                .stream()
//                .map(ProjectResponse::from)/**/
//                .collect(Collectors.toList());
//        return new PagePostResponse(postsResponses, posts.hasNext());
//    }
}
