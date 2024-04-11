package consolelog.like.domain;

import consolelog.global.config.BaseEntity;
import consolelog.member.domain.Member;
import consolelog.project.domain.Project;
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
    private Project project;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    protected PostLike() {

    }

    @Builder
    private PostLike(Project project, Member member) {
        this.project = project;
        this.member = member;
        project.addPostLike(this);
    }

    public boolean isLikeOf(Long memberId) {
        return member.hasId(memberId);
    }

    public void delete() {
        this.project = null;
    }
}
