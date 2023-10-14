package consolelog.comment.domain;


import jakarta.persistence.*;
import lombok.Builder;
import org.apache.logging.log4j.message.Message;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
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

    private String nickname;


    @Embedded
    private Message message;

    private boolean softRemoved;

    //댓글 좋아요 수
    private int likeCount;

    @CreatedDate
    private LocalDateTime created_at;


    @Builder
    public Comment(Member member, Post post, String nickname, String message, Comment parent) {
        this.member = member;
        this.post = post;
        this.nickname = nickname;
        this.message = new Message(message);
        this.parent = parent;
    }

    public



    //뭔 소린지 일도 모르겠습니다
}

