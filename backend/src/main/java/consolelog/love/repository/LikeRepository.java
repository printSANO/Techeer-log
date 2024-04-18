package consolelog.love.repository;

import consolelog.love.domain.Love;
import consolelog.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LikeRepository extends JpaRepository<Love, Long> {
    void deleteAllByProject(Project project);


}
