package consolelog.project.repository;

import consolelog.project.domain.Project;
import consolelog.project.domain.ProjectMember;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
    void deleteAllByProjectId(Long projectId);

}
