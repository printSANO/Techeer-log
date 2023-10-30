package consolelog.post.domain;

import consolelog.member.domain.Member;
import consolelog.post.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@AllArgsConstructor
@EntityListeners(value = {AuditingEntityListener.class})
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Lob
    private String content;

    //    @Column(name = "deleted")
    @SQLDelete(sql = "UPDATE post SET deleted = true WHERE id=?")
    @Where(clause = "deleted = false")
    private Boolean deleted = Boolean.FALSE;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

//    @OneToMany(mappedBy = "post")
//    private List<Comment> comments = new ArrayList<>();

    //    @Column(nullable = false)
//    private Long view_count;
//
//    @Column(nullable = false)
//    private Long like_count;
//    @Column(nullable = false)
//    @CreatedDate
//    private LocalDateTime created_at;
    //
//    @LastModifiedDate
//    @Column
//    private LocalDateTime updated_at;
//    private Boolean deleted_at;


    protected Post() {
    }

    @Builder
    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;

//        this.view_count = view_count;
//        this.like_count = like_count;
//        this.created_at = created_at;
//        this.updated_at = updated_at;
//        this.deleted_at = deleted_at;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Member getMember() {
        return member;
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