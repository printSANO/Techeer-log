package consolelog.like.domain;

import consolelog.config.BaseEntity;
import consolelog.member.domain.Member;
import consolelog.post.domain.Post;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class PostLike extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    protected PostLike() {

    }

    @Builder
    private PostLike(Post post, Member member) {
        this.post = post;
        this.member = member;
        post.addPostLike(this);
    }

    public boolean isLikeOf(Long memberId) {
        return member.hasId(memberId);
    }

    public void delete() {
        this.post = null;
    }
}
