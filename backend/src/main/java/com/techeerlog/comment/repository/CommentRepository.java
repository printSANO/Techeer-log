package com.techeerlog.comment.repository;

import com.techeerlog.comment.domain.Comment;
import com.techeerlog.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByProjectId(Long projectId);

    void deleteAllByProject(Project project);

}
