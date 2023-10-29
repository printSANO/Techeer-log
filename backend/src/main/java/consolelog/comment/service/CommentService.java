package consolelog.comment.service;


import consolelog.auth.dto.AuthInfo;
import consolelog.auth.service.AuthService;
import consolelog.comment.domain.Comment;
import consolelog.comment.domain.CommentDeletionEvent;
import consolelog.comment.dto.*;
import consolelog.comment.exception.CommentNotFoundException;
import consolelog.comment.exception.ReplyDepthException;
import consolelog.comment.repository.CommentRepository;
import consolelog.like.repository.CommentLikeRepository;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.post.domain.Post;
import consolelog.post.repository.PostRepository;
import org.springframework.context.ApplicationEventPublisher;
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
    private final PostRepository postRepository;
    private final CommentLikeRepository commentLikeRepository;
    private final AuthService authService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CommentService(CommentRepository commentRepository, MemberRepository memberRepository,
                          PostRepository postRepository, CommentLikeRepository commentLikeRepository,
                          AuthService authService, ApplicationEventPublisher applicationEventPublisher,) {
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
        this.commentLikeRepository = commentLikeRepository;
        this.authService = authService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    public Long addComment(Long postId, NewCommentRequest newCommentRequest, AuthInfo authInfo) {
//        Post post = postRepository.findById(postId)
//                .orElseThrow(PostNotFoundException::new);
//        authService.checkAuthority(authInfo, post.getBoardId());
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);

//        String nickname = commentNicknameGenerator.getcommentNickname(newCommentRequest.isAnonymous(), authInfo, post);

        Comment comment = Comment.parent(member, newCommentRequest.getContent());

        commentRepository.save(comment);

        return comment.getId();
    }

    //대댓글
    @Transactional
    public Long addReply(Long commentId, NewReplyRequest newReplyRequest, AuthInfo authInfo) {
        Comment parent = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);
//        authService.checkAuthority(authInfo, parent.getBoardId());
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);

        if (!parent.isParent()) {
            throw new ReplyDepthException();
        }
        Post post = parent.getPost();

//        String nickname = commentNicknameGenerator.getcommentNickname(newReplyRequest.isAnonymous(), authInfo, post);

        Comment reply = Comment.child(member, post, newReplyRequest.getContent(), parent);

        commentRepository.save(reply);
        return reply.getId();
    }

    //댓글들 조회하고 응답 생성
    public CommentsResponse findComments(Long postId, AuthInfo authInfo) {
        List<Comment> comments = commentRepository.findCommentsByPostId(postId);
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
            replyResponses.add(ReplyResponse.of(reply, accessMemberId, liked));
        }
        return replyResponses;
    }


    @Transactional
    public void deleteComment(Long commentId, AuthInfo authInfo) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);
        comment.validateOwner(authInfo.getId());
        applicationEventPublisher.publishEvent(new CommentDeletionEvent(comment.getId()));
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



