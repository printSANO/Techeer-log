package consolelog.project.repository;

import consolelog.project.domain.NonRegisterProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonRegisterProjectMemberRepository extends JpaRepository<NonRegisterProjectMember, Long> {
    void deleteAllByProjectId(Long projectId);
}