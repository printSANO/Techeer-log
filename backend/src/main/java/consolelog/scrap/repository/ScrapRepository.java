package consolelog.scrap.repository;

import consolelog.scrap.domain.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScrapRepository extends JpaRepository<Scrap, Long> {

    //특정 멤버와 프로젝트에 대한 스크랩 찾기
    Optional<Scrap> findByMemberIdAndProjectId(Long memberId, Long projectId);

    //스크랩 존재 여부 확인 하기
    boolean existsByMemberIdAndProjectId(Long memberId, Long projectId);

    //스크랩 삭제
    void deleteByMemberIdAndProjectId(Long memberId, Long projectId);

}
