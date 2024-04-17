package consolelog.scrap.repository;

import consolelog.scrap.domain.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScrapRepository extends JpaRepository<Scrap, Long> {

    //특정 멤버의 스크랩 목록 조회
    List<Scrap> findAllByMemberId(Long memberId);

    //특정 프로젝트에 대한 스크랩 여부 확인
    boolean existsByMemberIdAndProjectId(Long memberId, Long projectId);
}
