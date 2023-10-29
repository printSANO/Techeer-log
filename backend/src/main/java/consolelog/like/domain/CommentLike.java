package consolelog.like.domain;

import consolelog.comment.domain.Comment;
import consolelog.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity(name = "comment_likes")
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_likes_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    protected CommentLike() {
    }

    @Builder
    private CommentLike(Comment comment, Member member) {
        this.comment = comment;
        this.member = member;
        comment.addCommentLike(this);
    }

    public boolean isLikeOf(Long memberId) {
        return member.hasId(memberId);
    }

    public void delete() {
        this.comment = null;
    }
}
