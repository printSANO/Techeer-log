package consolelog.comment.service;


import consolelog.auth.dto.AuthInfo;
import consolelog.comment.domain.Comment;
import consolelog.comment.dto.*;
import consolelog.comment.exception.CommentNotFoundException;
import consolelog.comment.repository.CommentRepository;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.project.domain.Project;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.ProjectRepository;
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

        return CommentResponse.of(comment, authInfo.getId());
    }


    //댓글들 조회하고 응답 생성
    public CommentsResponse findComments(Long projectId, AuthInfo authInfo) {
        if (!projectRepository.existsById(projectId)) {
            throw new CommentNotFoundException();
        }
        List<Comment> comments = commentRepository.findCommentsByProjectId(projectId);
        List<CommentResponse> commentResponses = comments.stream()
                .map(it -> convertToCommentResponse(authInfo, it))
                .toList();
        int numOfComment = commentResponses.size();
        return new CommentsResponse(commentResponses, numOfComment );
    }

    private CommentResponse convertToCommentResponse(AuthInfo authInfo, Comment comment) {
        Long id = authInfo.getId();
        if (comment.isSoftRemoved()) {
            return CommentResponse.softRemovedOf(comment);
        }
        return CommentResponse.of(comment, id);
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

        return CommentResponse.of(updatedComment, authInfo.getId());
    }
}



