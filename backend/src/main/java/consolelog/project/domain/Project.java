package consolelog.project.domain;

import consolelog.comment.domain.Comment;
import consolelog.love.domain.Love;
import consolelog.member.domain.Member;
import consolelog.global.config.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;


@Entity
@AllArgsConstructor
@Getter
@EntityListeners(value = {AuditingEntityListener.class})
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column
    @Setter
    private String mainImageUrl;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subtitle;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private String projectType;

    @Column
    private String projectStatus;

    @Column
    private String semester;

    @Column
    private String githubLink;

    @Column
    private String blogLink;

    @Column
    private String websiteLink;

    private int viewCount = 0;
    private int likeCount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "project")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Love> likes = new ArrayList<>();

    //    @Column(name = "deleted")
    @SQLDelete(sql = "UPDATE project SET deleted = TRUE WHERE id=?")
    @Where(clause = "deleted = FALSE")
    private Boolean deleted = FALSE;

    protected Project() {
    }

    @Builder
    public Project(String title, String content, String mainImageUrl, Member member,
                   List<Comment> comments, List<Love> likes) {
        this.title = title;
        this.content = content;
        this.mainImageUrl = mainImageUrl;
        this.member = member;
        this.comments = comments;
        this.likes = likes;
    }

    public int getCommentCount() {
        if (comments == null)
            return 0;
        return comments.size();
    }

    public void addPostLike(Love love) {
        this.likes.add(love);
    }

    public void deleteLike(Love love) {
        this.likes.remove(love);
        love.delete();
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public boolean isOwner(Long accessMemberId) {
        if (accessMemberId == null) {
            return false;
        }
        return member.getId().equals(accessMemberId);
    }
}