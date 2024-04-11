package consolelog.like.repository;

import consolelog.like.domain.PostLike;
import consolelog.member.domain.Member;
import consolelog.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    void deleteAllByProject(Project project);


    boolean existsByProjectAndMemberId(Project project, Long memberId);


    @Query("select p from PostLike p where p.project = ?1 and p.member.id = ?2")
    Optional<PostLike> findByPostAndMemberId(Project project, Long memberId);

    Optional<PostLike> findByProjectAndMember(Project project, Member member);


}
