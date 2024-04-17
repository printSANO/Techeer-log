package consolelog.scrap.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;

import consolelog.project.domain.Project;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.ProjectRepository;
import consolelog.scrap.domain.Scrap;
import consolelog.scrap.exception.ScrapAlreadyExistsException;
import consolelog.scrap.exception.ScrapNotFoundException;
import consolelog.scrap.repository.ScrapRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


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
    public void createScrap(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);

        // 스크랩 중복 확인
        scrapRepository.findByMemberIdAndProjectId(member.getId(), project.getId())
                .ifPresent(scrap -> {
                    throw new ScrapAlreadyExistsException();
                });

        Scrap scrap = new Scrap(member, project);

        scrapRepository.save(scrap);
    }

    @Transactional
    public void deleteScrap(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);

        if (!scrapRepository.existsByMemberIdAndProjectId(member.getId(), project.getId())) {
            throw new ScrapNotFoundException();
        }
        scrapRepository.deleteByMemberIdAndProjectId(member.getId(), project.getId());
    }

}
