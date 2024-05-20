package com.techeerlog.comment.service;

import com.techeerlog.auth.dto.AuthInfo;
import com.techeerlog.comment.domain.Comment;
import com.techeerlog.comment.dto.CommentRequest;
import com.techeerlog.comment.dto.CommentResponse;
import com.techeerlog.comment.dto.CommentsResponse;
import com.techeerlog.comment.exception.CommentNotFoundException;
import com.techeerlog.comment.repository.CommentRepository;
import com.techeerlog.member.domain.Member;
import com.techeerlog.member.exception.MemberNotFoundException;
import com.techeerlog.member.repository.MemberRepository;
import com.techeerlog.project.domain.Project;
import com.techeerlog.project.exception.ProjectNotFoundException;
import com.techeerlog.project.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    public CommentService(CommentRepository commentRepository, MemberRepository memberRepository,
                          ProjectRepository projectRepository) {
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
        this.projectRepository = projectRepository;
    }

    @Transactional
    public CommentResponse addComment(CommentRequest commentRequest, AuthInfo authInfo) {
        Project project = projectRepository.findById(commentRequest.getProjectId())
                .orElseThrow(ProjectNotFoundException::new);
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);

        Comment comment = Comment.builder()
                .member(member)
                .project(project)
                .message(commentRequest.getContent())
                .build();
        commentRepository.save(comment);

        return CommentResponse.of(comment, true);
    }

    //댓글들 조회하고 응답 생성
    public CommentsResponse findComments(Long projectId, AuthInfo authInfo) {
        if (!projectRepository.existsById(projectId)) {
            throw new ProjectNotFoundException();
        }
        List<Comment> comments = commentRepository.findCommentsByProjectId(projectId);
        List<CommentResponse> commentResponses = comments.stream()
                .map(comment -> {
                    boolean isAuthorized = comment.getMember().getId().equals(authInfo.getId());
                    return CommentResponse.of(comment, isAuthorized);
                })
                .toList();
        int numOfComment = commentResponses.size();

        return new CommentsResponse(commentResponses, numOfComment);
    }

    @Transactional
    public void deleteComment(Long commentId, AuthInfo authInfo) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);
        comment.validateOwner(authInfo.getId());
        commentRepository.delete(comment);
    }

    @Transactional
    public CommentResponse updateComment(Long commentId, CommentRequest updateCommentRequest, AuthInfo authInfo) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);

        comment.validateOwner(authInfo.getId());

        comment.updateContent(updateCommentRequest.getContent());
        Comment updatedComment = commentRepository.save(comment);

        return CommentResponse.of(updatedComment, true);
    }
}