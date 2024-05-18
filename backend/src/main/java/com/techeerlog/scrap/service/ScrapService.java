package com.techeerlog.scrap.service;

import com.techeerlog.auth.dto.AuthInfo;
import com.techeerlog.global.support.UtilMethod;
import com.techeerlog.member.domain.Member;
import com.techeerlog.project.domain.Project;
import com.techeerlog.project.exception.ProjectNotFoundException;
import com.techeerlog.project.repository.ProjectRepository;
import com.techeerlog.scrap.domain.Scrap;
import com.techeerlog.scrap.dto.ScrapResponse;
import com.techeerlog.scrap.exception.ScrapAlreadyExistsException;
import com.techeerlog.scrap.exception.ScrapNotFoundException;
import com.techeerlog.scrap.repository.ScrapRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ScrapService {
    private final ScrapRepository scrapRepository;
    private final ProjectRepository projectRepository;
    private final UtilMethod utilMethod;

    public ScrapService(ScrapRepository scrapRepository,
                        ProjectRepository projectRepository,
                        UtilMethod utilMethod) {
        this.scrapRepository = scrapRepository;
        this.projectRepository = projectRepository;
        this.utilMethod = utilMethod;
    }

    public ScrapResponse createScrap(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = utilMethod.findMemberByAuthInfo(authInfo);

        // 스크랩 중복 확인
        if (scrapRepository.existsByMemberIdAndProjectId(member.getId(), project.getId())) {
            throw new ScrapAlreadyExistsException();
        }
        Scrap scrap = Scrap.builder()
                .project(project)
                .member(member)
                .build();
        scrapRepository.save(scrap);

    return new ScrapResponse(scrap.getId(), project.getId());
    }

    public ScrapResponse deleteScrap(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = utilMethod.findMemberByAuthInfo(authInfo);

        Optional<Scrap> scrap = scrapRepository.findByMemberIdAndProjectId(member.getId(), project.getId());
        if (scrap.isEmpty()) {
            throw new ScrapNotFoundException();
        }
        Long scrapId = scrap.get().getId();
        scrapRepository.delete(scrap.get());
        return new ScrapResponse(scrapId, project.getId());
    }

}
