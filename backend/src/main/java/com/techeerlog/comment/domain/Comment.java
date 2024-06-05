package com.techeerlog.comment.domain;


import com.techeerlog.auth.exception.AuthorizationException;
import com.techeerlog.global.config.BaseEntity;
import com.techeerlog.member.domain.Member;
import com.techeerlog.project.domain.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Entity
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE comment SET deleted = True WHERE comment_id = ?")
@SQLRestriction("deleted = FALSE")
public class Comment extends BaseEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Embedded
    private Message message;

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

