package consolelog.comment.domain;

import consolelog.auth.dto.AuthInfo;
import consolelog.comment.repository.CommentRepository;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


// 댓글 닉네임을 생성할때 익명 여부, 사용자 정보, 게시물 정보 고려해 적절한 닉네임 반환하는 역할
@Component
public class CommentNicknameGenerator {
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    public CommentNicknameGenerator(MemberRepository memberRepository, CommentRepository commentRepository) {
        this.memberRepository = memberRepository;
        this.commentRepository = commentRepository;
    }

    //댓글 닉네임 가져오는 매서드(익명이면 getAnonymousNickname 호출)
    public String getcommentNickname(boolean anoymous, AuthInfo authInfo, Post post) {
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);
        if (!anoymous) {
            return member.getNickname();
        }
        return getAnonymousNickname(post, member);
    }

    //현재 사용자 =게시물 작성자&익명작성자 -> 익명 닉네임 반환
    private String getAnonymousNickname(Post post, Member member) {
        if (post.isOwner(member.getId()) && post.isAnonymous()) {
            return post.getNickname();
        }
        return findPreviousAnonymousNicknameOrElseNewRandomNickname(post, member);
    }

    private String findPreviousAnonymousNicknameOrElseNewRandomNickname(Post post, Member member) {
        List<String> commentNicknamesByPostAndMember = commentRepository.findNickNamesByPostAndMember(post, member);
        return commentNicknamesByPostAndMember.stream()
                .filter(nickname -> !nickname.equals(member.getNickname()))
                .findFirst()
                .orElse(generateNewRandomNickname(post));
    }

    private String generateNewRandomNickname(Post post) {
        Set<String> alreadyUsedNickname = new HashSet<>(commentRepository.findNicknamesByPostId(post.getId()));
        alreadyUsedNickname.add(post.getNickname());
        return RandomNIcknameGenerator.generate(alreadyUsedNickname);
    }
}
