package consolelog.scrap.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.support.UtilMethod;
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
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ScrapService {
    private final ScrapRepository scrapRepository;
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final UtilMethod utilMethod;

    public ScrapService(ScrapRepository scrapRepository,
                        ProjectRepository projectRepository,
                        MemberRepository memberRepository,
                        UtilMethod utilMethod) {
        this.scrapRepository = scrapRepository;
        this.projectRepository = projectRepository;
        this.memberRepository = memberRepository;
        this.utilMethod = utilMethod;
    }

    public void createScrap(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = utilMethod.findMemberByAuthInfo(authInfo);

        // 스크랩 중복 확인
        scrapRepository.findByMemberIdAndProjectId(member.getId(), project.getId())
                .ifPresent(scrap -> {
                    throw new ScrapAlreadyExistsException();
                });

        scrapRepository.save(new Scrap(member, project));
    }

    public void deleteScrap(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);

        Optional<Scrap> scrap = scrapRepository.findByMemberIdAndProjectId(member.getId(), project.getId());
        if (scrap.isEmpty()) {
            throw new ScrapNotFoundException();
        }

        scrapRepository.delete(scrap.get());

    }

}
