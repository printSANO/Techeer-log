package consolelog.love.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.support.UtilMethod;
import consolelog.love.domain.Love;
import consolelog.love.exception.LikeNotFoundException;
import consolelog.love.repository.LikeRepository;
import consolelog.member.domain.Member;
import consolelog.project.domain.Project;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.ProjectRepository;
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
