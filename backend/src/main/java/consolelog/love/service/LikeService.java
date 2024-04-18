package consolelog.love.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.comment.repository.CommentRepository;
import consolelog.love.domain.Love;
import consolelog.love.dto.LikeFlipResponse;
import consolelog.love.repository.LikeRepository;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.project.domain.Project;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class LikeService {
    private final LikeRepository likeRepository;
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;


    public LikeService(LikeRepository likeRepository, ProjectRepository projectRepository,
                       MemberRepository memberRepository, CommentRepository commentRepository) {

        this.likeRepository = likeRepository;
        this.projectRepository = projectRepository;
        this.memberRepository = memberRepository;
        this.commentRepository = commentRepository;
    }


}
