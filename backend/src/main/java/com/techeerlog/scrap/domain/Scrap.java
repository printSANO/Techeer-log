package com.techeerlog.scrap.domain;

import com.techeerlog.global.config.BaseEntity;
import com.techeerlog.member.domain.Member;
import com.techeerlog.project.domain.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@AllArgsConstructor
@Getter
public class Scrap extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scrap_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    protected Scrap() {
    }

    public Scrap(Member member, Project project) {
        this.member = member;
        this.project = project;
    }

}
