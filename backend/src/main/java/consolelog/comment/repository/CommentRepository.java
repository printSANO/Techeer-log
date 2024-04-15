package consolelog.comment.repository;

import consolelog.comment.domain.Comment;
import consolelog.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 수정 필요
    // Param 을 2개 넘겨주고, (postId, null) 을 넘겨줘서 데이터를 가져 올 수 있을 것 같다
    // 최대한 Query 의 사용을 자제하라
    List<Comment> findCommentsByProjectId(Long projectId);


    void deleteAllByProject(Project project);

}
