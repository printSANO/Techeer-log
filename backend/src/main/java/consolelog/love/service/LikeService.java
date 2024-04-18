package consolelog.love.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.love.domain.Love;
import consolelog.love.exception.LikeNotFoundException;
import consolelog.love.repository.LikeRepository;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.project.domain.Project;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;


    public LikeService(LikeRepository likeRepository, ProjectRepository projectRepository,
                       MemberRepository memberRepository) {

        this.likeRepository = likeRepository;
        this.projectRepository = projectRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void addLove(Long projectId, AuthInfo authInfo) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);

        Love love = Love.builder().project(project).member(member).build();

        likeRepository.save(love);
    }

    @Transactional
    public void deleteLove(Long loveId, AuthInfo authInfo) {
        Love love = likeRepository.findById(loveId)
                .orElseThrow(LikeNotFoundException::new);
        love.isLikeOf(authInfo.getId());

        likeRepository.delete(love);
    }



}
