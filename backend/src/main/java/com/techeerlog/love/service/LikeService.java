package com.techeerlog.love.service;

import com.techeerlog.auth.dto.AuthInfo;
import com.techeerlog.global.support.UtilMethod;
import com.techeerlog.love.domain.Love;
import com.techeerlog.love.exception.LikeNotFoundException;
import com.techeerlog.love.repository.LoveRepository;
import com.techeerlog.member.domain.Member;
import com.techeerlog.project.domain.Project;
import com.techeerlog.project.exception.ProjectNotFoundException;
import com.techeerlog.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LikeService {
    private final LoveRepository loveRepository;
    private final ProjectRepository projectRepository;
    private final UtilMethod utilMethod;


    public LikeService(LoveRepository loveRepository, ProjectRepository projectRepository,
                       UtilMethod utilMethod) {

        this.loveRepository = loveRepository;
        this.projectRepository = projectRepository;
        this.utilMethod = utilMethod;
    }

    public void addLove(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = utilMethod.findMemberByAuthInfo(authInfo);

        loveRepository.findByMemberIdAndProjectId(member.getId(), project.getId())
                .ifPresent(love -> {
                    throw new LikeNotFoundException();
                });
        loveRepository.save(Love.builder()
                .project(project)
                .member(member)
                .build());
    }

    public void deleteLove(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = utilMethod.findMemberByAuthInfo(authInfo);

        Optional<Love> love = loveRepository.findByMemberIdAndProjectId(member.getId(), project.getId());
        if (love.isEmpty()) {
            throw new LikeNotFoundException();
        }
        loveRepository.delete(love.get());
    }
}
