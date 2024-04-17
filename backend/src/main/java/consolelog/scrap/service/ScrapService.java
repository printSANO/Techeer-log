package consolelog.scrap.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;

import consolelog.project.domain.Project;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.ProjectRepository;
import consolelog.scrap.domain.Scrap;
import consolelog.scrap.dto.ScrapResponse;
import consolelog.scrap.repository.ScrapRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrapService {
    private final ScrapRepository scrapRepository;
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;

    public ScrapService(ScrapRepository scrapRepository,
                        ProjectRepository projectRepository,
                        MemberRepository memberRepository) {
        this.scrapRepository = scrapRepository;
        this.projectRepository = projectRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Scrap createScrap(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);
        Scrap scrap = new Scrap(member, project);

        scrapRepository.save(scrap);

        return scrap;
    }


    @Transactional
    public List<ScrapResponse> getScrapsByMemberId(Long memberId) {
        List<Scrap> scraps = scrapRepository.findAllByMemberId(memberId);
        return scraps.stream()
                .map(scrap -> new ScrapResponse(
                        scrap.getId(),
                        scrap.getProject().getId(),
                        scrap.getProject().getMainImageUrl(),
                        scrap.getProject().getTitle(),
                        scrap.getProject().getSubtitle()))
                .toList(); // Stream.toList() 메소드를 사용하여 리스트로 변환
    }


}
