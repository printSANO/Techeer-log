package consolelog.comment.service;


import consolelog.auth.dto.AuthInfo;
import consolelog.auth.service.AuthService;
import consolelog.comment.domain.Comment;
import consolelog.comment.domain.CommentNicknameGenerator;
import consolelog.comment.dto.*;
import consolelog.comment.exception.CommentNotFoundException;
import consolelog.comment.exception.ReplyDepthException;
import consolelog.comment.repository.CommentRepository;
import consolelog.like.repository.CommentLikeRepository;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.project.domain.Project;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;
    private final CommentLikeRepository commentLikeRepository;
    // 수정 필요
    // 안 쓰는 변수 삭제
    private final AuthService authService;
    private final CommentNicknameGenerator commentNicknameGenerator;


    public CommentService(CommentRepository commentRepository, MemberRepository memberRepository,
                          ProjectRepository projectRepository, CommentLikeRepository commentLikeRepository,
                          AuthService authService, CommentNicknameGenerator commentNicknameGenerator) {
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
        this.projectRepository = projectRepository;
        this.commentLikeRepository = commentLikeRepository;
        this.authService = authService;
        this.commentNicknameGenerator = commentNicknameGenerator;
    }

    @Transactional
    public Long addComment(Long postId, NewCommentRequest newCommentRequest, AuthInfo authInfo) {
        Project project = projectRepository.findById(postId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);

        Comment comment = Comment.parent(member, project, newCommentRequest.getContent(), null);

        commentRepository.save(comment);

        return comment.getId();
    }


    //대댓글
    @Transactional
    public Long addReply(Long commentId, NewReplyRequest newReplyRequest, AuthInfo authInfo) {
        Comment parent = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);

        if (!parent.isParent()) {
            throw new ReplyDepthException();
        }
        Project project = parent.getProject();

//        String nickname = commentNicknameGenerator.getcommentNickname(newReplyRequest.isAnonymous(), authInfo, post);

        Comment reply = Comment.child(member, project, newReplyRequest.getContent(), parent);
        parent.getChildren().add(reply);

        commentRepository.save(reply);
        return reply.getId();
    }


    //댓글들 조회하고 응답 생성
    public CommentsResponse findComments(Long projectId, AuthInfo authInfo) {
        if (!projectRepository.existsById(projectId)) {
            throw new ProjectNotFoundException();
        }
        List<Comment> comments = commentRepository.findCommentsByProjectId(projectId);
        List<CommentResponse> commentResponses = comments.stream()
                .map(it -> convertToCommentResponse(authInfo, it))
                .collect(Collectors.toList());
        int numOfComment = commentResponses.size();
        int numOfReply = commentResponses.stream()
                .map(it -> it.getReplies().size())
                .reduce(Integer::sum).orElse(0);
        return new CommentsResponse(commentResponses, numOfComment + numOfReply);
    }

    private CommentResponse convertToCommentResponse(AuthInfo authInfo, Comment comment) {
        Long id = authInfo.getId();
        if (comment.isSoftRemoved()) {
            return CommentResponse.softRemovedOf(comment, convertToReplyResponses(comment, id));
        }
        boolean liked = commentLikeRepository.existsByMemberIdAndComment(id, comment);
        return CommentResponse.of(comment, id, convertToReplyResponses(comment, id), liked);
    }

    private List<ReplyResponse> convertToReplyResponses(Comment parent, Long accessMemberId) {
        final List<Comment> replies = commentRepository.findRepliesByParent(parent);
        List<ReplyResponse> replyResponses = new ArrayList<>();
        for (Comment reply : replies) {
            boolean liked = commentLikeRepository.existsByMemberIdAndComment(accessMemberId, reply);
            replyResponses.add(ReplyResponse.of(reply, liked));
        }
        return replyResponses;
    }


    @Transactional
    public void deleteComment(Long commentId, AuthInfo authInfo) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);
        comment.validateOwner(authInfo.getId());
        commentLikeRepository.deleteAllByCommentId(commentId);

        deleteCommentOrReply(comment);
    }

    private void deleteCommentOrReply(Comment comment) {
        if (comment.isParent()) {
            deleteParent(comment);
            return;
        }

        deleteChild(comment);
    }

    private void deleteParent(Comment comment) {
        if (comment.hasNoReply()) {
            commentRepository.delete(comment);
            return;
        }
        comment.changePretendingToBeRemoved();
    }

    private void deleteChild(Comment comment) {
        Comment parent = comment.getParent();
        parent.deleteChild(comment);
        commentRepository.delete(comment);

        if (parent.hasNoReply() && parent.isSoftRemoved()) {
            commentRepository.delete(parent);
        }
    }

    @Transactional
    // 수정 필요
    // 반환값이 사용되고 있지 않다고 한다. 코드를 한 번 더 확인해보아라
    // 항상 경고표시가 나오면, 왜 발생하는지 확인해라
    public CommentResponse updateComment(Long commentId, UpdateCommentRequest updateCommentRequest, AuthInfo authInfo) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);

        comment.validateOwner(authInfo.getId());

        comment.updateContent(updateCommentRequest.getContent());
        Comment updatedComment = commentRepository.save(comment);

        return CommentResponse.of(updatedComment, authInfo.getId(), convertToReplyResponses(updatedComment, authInfo.getId()), false);
    }
}



