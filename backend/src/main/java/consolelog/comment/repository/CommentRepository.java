package consolelog.comment.repository;

import consolelog.comment.domain.Comment;
import consolelog.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByProjectId(Long projectId);

    void deleteAllByProject(Project project);

}
