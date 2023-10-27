package consolelog.member.service;

import consolelog.member.domain.*;
import consolelog.member.dto.EditNicknameRequest;
import consolelog.member.dto.NicknameResponse;
import consolelog.member.dto.SignupRequest;
import consolelog.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Encryptor 추가해야함
    @Transactional
    public void signUp(SignupRequest signupRequest) {
        Member member = Member.builder()
                .username(new Username(signupRequest.getUsername()))
                .password(new Password(signupRequest.getPassword()))
                .email(new Email(signupRequest.getEmail()))
                .nickname(new Nickname(signupRequest.getNickname()))
                .build();
        memberRepository.save(member);
    }
    // else throw 넣어야 함
    @Transactional
    public void editNickname(EditNicknameRequest editNicknameRequest, AuthInfo authInfo) {
        Member member = memberRepository.findById(authInfo.getId())

        Nickname validNickname = new Nickname(editNicknameRequest.getNickname());
        member.updateNickname(validNickname);
    }

    public NicknameResponse findNickname(AuthInfo authInfo) {
        Member member = memberRepository.findById(authInfo.getId());
        return NicknameResponse.of(member);
    }
}
