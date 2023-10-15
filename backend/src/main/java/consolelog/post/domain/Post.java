package consolelog.post.domain;

import consolelog.post.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


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
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
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


}
