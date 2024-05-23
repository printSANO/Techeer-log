package com.techeerlog.project.repository;

import com.techeerlog.project.domain.ProjectFramework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectFrameworkRepository extends JpaRepository<ProjectFramework, Long> {

    void deleteAllByProjectId(Long projectId);
}
