package com.techeerlog.project.repository;

import com.techeerlog.project.domain.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
    void deleteAllByProjectId(Long projectId);

}
