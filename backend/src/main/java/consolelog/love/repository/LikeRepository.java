package consolelog.love.repository;

import consolelog.love.domain.Love;
import consolelog.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface LikeRepository extends JpaRepository<Love, Long> {

    Optional<Love> findByMemberIdAndProjectId(Long memberId, Long projectId);
    void deleteAllByProject(Project project);

}
