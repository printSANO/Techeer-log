package consolelog.comment.domain;


import consolelog.auth.exception.AuthorizationException;
import consolelog.like.domain.CommentLike;
import consolelog.member.domain.Member;
import consolelog.post.domain.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    //대댓글
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @OneToMany(mappedBy = "parent")
    private List<Comment> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CommentLike> commentLikes = new ArrayList<>();

    @Embedded
    private Message message;

    private boolean softRemoved;

    private int likeCount;

    @CreatedDate
    private LocalDateTime createdAt;

    protected Comment() {
    }

    @Builder
    public Comment(Member member, Post post, String message, Comment parent) {
        this.member = member;
        this.post = post;
        this.message = new Message(message);
        this.parent = parent;
    }

    public static Comment parent(Member member, Post post, String message, Comment parent) {
        return Comment.builder()
                .member(member)
                .post(post)
                .message(message)
                .parent(parent)
                .build();
    }

    public static Comment child(Member member, Post post, String message, Comment parent) {
        // 수정 필요
        // 즉시 값을 반환하는 방식으로 변경
        Comment child = Comment.builder()
                .member(member)
                .post(post)
                .message(message)
                .parent(parent)
                .build();
        return child;
    }


    //  댓글 작성자의 아이디와 일치하는지 확인
    public void validateOwner(Long accessMemberId) {
        if (!accessMemberId.equals(member.getId())) {
            throw new AuthorizationException();
        }
    }

    // 댓글 수정, 삭제 할 때 해당 댓글 작성한 사용자인지 확인
    public boolean isAuthorized(Long accessMemberId) {
        if (accessMemberId == null) {
            return false;
        }
        return member.getId().equals(accessMemberId);
    }

    // 수정 필요
    // Getter 사용가능한 변수는 @Getter 로 수정
    public Long getId() {
        return id;
    }

    public Comment getParent() {
        return parent;
    }


    public List<Comment> getChildren() {
        return children;
    }


    public Member getMember() {
        return member;
    }


    public Post getPost() {
        return post;
    }

    public String getNickname() {
        return member.getNickname();
    }

    public String getMessage() {
        return message.getValue();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getCommentLikesCount() {
        return likeCount;
    }

    public boolean isSoftRemoved() {
        return softRemoved;
    }

    public void changePretendingToBeRemoved() {
        this.softRemoved = true;
    }

    public void deleteChild(Comment reply) {
        children.remove(reply);
    }

    public boolean isParent() {
        return Objects.isNull(parent);
    }

    public boolean hasNoReply() {
        return children.isEmpty();
    }

    public void addCommentLike(CommentLike commentLike) {
        commentLikes.add(commentLike);
    }

    public void deleteLike(CommentLike commentLike) {
        commentLikes.remove(commentLike);
        commentLike.delete();
    }

    public void updateContent(String content) {
        this.message = new Message(content);
    }
}

