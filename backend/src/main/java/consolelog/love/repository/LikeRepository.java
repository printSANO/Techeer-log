package consolelog.love.repository;

import consolelog.love.domain.Love;
import consolelog.member.domain.Member;
import consolelog.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Love, Long> {

    void deleteAllByProject(Project project);


    boolean existsByProjectAndMemberId(Project project, Long memberId);


    @Query("select p from Love p where p.project = ?1 and p.member.id = ?2")
    Optional<Love> findByPostAndMemberId(Project project, Long memberId);

    Optional<Love> findByProjectAndMember(Project project, Member member);


}
