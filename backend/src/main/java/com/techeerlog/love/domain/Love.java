package com.techeerlog.love.domain;

import com.techeerlog.global.config.BaseEntity;
import com.techeerlog.member.domain.Member;
import com.techeerlog.project.domain.Project;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Love extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "love_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    protected Love() {

    }

    @Builder
    private Love(Project project, Member member) {
        this.project = project;
        this.member = member;
    }

    public boolean isLikeOf(Long memberId) {
        return member.hasId(memberId);
    }

    public void delete() {
        this.project = null;
    }

}
