package consolelog.comment.domain;


import consolelog.auth.exception.AuthorizationException;
import consolelog.member.domain.Member;
import consolelog.project.domain.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Embedded
    private Message message;

    @Getter
    private boolean softRemoved;

    @Getter
    @CreatedDate
    private LocalDateTime createdAt;

    protected Comment() {
    }

    @Builder
    public Comment(Member member, Project project, String message) {
        this.member = member;
        this.project = project;
        this.message = new Message(message);
    }


    //  댓글 작성자의 아이디와 일치하는지 확인
    public void validateOwner(Long accessMemberId) {
        if (!accessMemberId.equals(member.getId())) {
            throw new AuthorizationException();
        }
    }

    public String getMessage() {
        return message.getValue();
    }

    public void updateContent(String content) {
        this.message = new Message(content);
    }
}

