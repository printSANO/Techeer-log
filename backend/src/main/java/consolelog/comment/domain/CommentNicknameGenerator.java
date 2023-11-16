package consolelog.comment.domain;

import consolelog.comment.repository.CommentRepository;
import consolelog.member.repository.MemberRepository;
import org.springframework.stereotype.Component;


// 댓글 닉네임을 생성할때 익명 여부, 사용자 정보, 게시물 정보 고려해 적절한 닉네임 반환하는 역할
@Component
public class CommentNicknameGenerator {
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    public CommentNicknameGenerator(MemberRepository memberRepository, CommentRepository commentRepository) {
        this.memberRepository = memberRepository;
        this.commentRepository = commentRepository;
    }

//    public String getcommentNickname(AuthInfo authInfo, Post post) {
//        Member member = memberRepository.findById(authInfo.getId())
//                .orElseThrow(MemberNotFoundException::new);
//
//        return member.getNickname();
//    }
}
//
//    //현재 사용자 =게시물 작성자&익명작성자 -> 익명 닉네임 반환
//    private String getAnonymousNickname(Post post, Member member) {
//        if (post.isOwner(member.getId())) {
//            return member.getId().toString(); // 사용자의 아이디를 반환
//        }
//        return findPreviousNicknameOrElseNewRandomNickname(post, member);
//    }
//
//
//    private String findPreviousNicknameOrElseNewRandomNickname(Post post, Member member) {
//        List<String> commentNicknamesByPostAndMember = commentRepository.findNickNamesByPostAndMember(post, member);
//        return commentNicknamesByPostAndMember.stream()
//                .filter(nickname -> !nickname.equals(member.getNickname()))
//                .findFirst()
//                .orElse(generateNewRandomNickname(post));
//    }
//
//    private String generateNewRandomNickname(Post post) {
//        Set<String> alreadyUsedNickname = new HashSet<>(commentRepository.findNicknamesByPostId(post.getId()));
//        alreadyUsedNickname.add(post.getNickname());
//        return RandomNIcknameGenerator.generate(alreadyUsedNickname);
//    }

