package com.techeerlog.scrap.service;

import com.techeerlog.auth.dto.AuthInfo;
import com.techeerlog.global.support.UtilMethod;
import com.techeerlog.member.domain.Member;
import com.techeerlog.member.exception.MemberNotFoundException;
import com.techeerlog.member.repository.MemberRepository;
import com.techeerlog.project.domain.Project;
import com.techeerlog.project.exception.ProjectNotFoundException;
import com.techeerlog.project.repository.ProjectRepository;
import com.techeerlog.scrap.domain.Scrap;
import com.techeerlog.scrap.exception.ScrapAlreadyExistsException;
import com.techeerlog.scrap.exception.ScrapNotFoundException;
import com.techeerlog.scrap.repository.ScrapRepository;
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
