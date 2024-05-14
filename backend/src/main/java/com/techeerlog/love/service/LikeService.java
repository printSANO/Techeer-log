package com.techeerlog.love.service;

import com.techeerlog.auth.dto.AuthInfo;
import com.techeerlog.global.support.UtilMethod;
import com.techeerlog.love.domain.Love;
import com.techeerlog.love.exception.LikeNotFoundException;
import com.techeerlog.love.repository.LikeRepository;
import com.techeerlog.member.domain.Member;
import com.techeerlog.project.domain.Project;
import com.techeerlog.project.exception.ProjectNotFoundException;
import com.techeerlog.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final ProjectRepository projectRepository;
    private final UtilMethod utilMethod;


    public LikeService(LikeRepository likeRepository, ProjectRepository projectRepository,
                       UtilMethod utilMethod) {

        this.likeRepository = likeRepository;
        this.projectRepository = projectRepository;
        this.utilMethod = utilMethod;
    }

    public void addLove(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = utilMethod.findMemberByAuthInfo(authInfo);

        likeRepository.findByMemberIdAndProjectId(member.getId(), project.getId())
                .ifPresent(love -> {
                    throw new LikeNotFoundException();
                });
        likeRepository.save(Love.builder()
                .project(project)
                .member(member)
                .build());
    }

    public void deleteLove(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = utilMethod.findMemberByAuthInfo(authInfo);

        Optional<Love> love = likeRepository.findByMemberIdAndProjectId(member.getId(), project.getId());
        if (love.isEmpty()) {
            throw new LikeNotFoundException();
        }
        likeRepository.delete(love.get());
    }
}
