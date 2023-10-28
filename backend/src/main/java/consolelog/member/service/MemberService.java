package consolelog.member.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.member.domain.*;
import consolelog.member.dto.EditNicknameRequest;
import consolelog.member.dto.NicknameResponse;
import consolelog.member.dto.SignupRequest;
import consolelog.member.dto.UniqueResponse;
import consolelog.member.exception.DuplicateNicknameException;
import consolelog.member.exception.InvalidSignupFlowException;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.exception.PasswordConfirmationException;
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
        validate(signupRequest);
        Member member = Member.builder()
                .loginId(new LoginId(signupRequest.getLoginId()))
                .password(new Password(signupRequest.getPassword()))
                .nickname(new Nickname(signupRequest.getNickname()))
                .build();
        memberRepository.save(member);
    }

    // encrypt 해야함.
    public UniqueResponse checkUniqueLoginId(String loginId) {
        boolean unique = !memberRepository.existsMemberByLoginIdValue(loginId);
        return new UniqueResponse(unique);
    }

    public UniqueResponse checkUniqueNickname(String nickname) {
        boolean unique = !memberRepository.existsMemberByNicknameValue(nickname);
        return new UniqueResponse(unique);
    }

    private void validate(SignupRequest signupRequest) {
        confirmPassword(signupRequest.getPassword(), signupRequest.getPasswordConfirmation());
        validateUniqueNickname(signupRequest);
        validateUniqueloginId(signupRequest);
    }

    private void validateUniqueloginId(SignupRequest signupRequest) {
        boolean isDuplicatedLoginId = memberRepository
                .existsMemberByLoginIdValue(signupRequest.getLoginId());
        if (isDuplicatedLoginId) {
            throw new InvalidSignupFlowException();
        }
    }

    // else throw 넣어야 함
    private void validateUniqueNickname(SignupRequest signupRequest) {
        boolean isDuplicatedNickname = memberRepository
                .existsMemberByNicknameValue(signupRequest.getNickname());
        if (isDuplicatedNickname) {
            throw new InvalidSignupFlowException();
        }
    }

    private void confirmPassword(String password, String passwordConfirmation) {
        if (!password.equals(passwordConfirmation)) {
            throw new PasswordConfirmationException();
        }
    }

    @Transactional
    public void editNickname(EditNicknameRequest editNicknameRequest, AuthInfo authInfo) {
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);

        Nickname validNickname = new Nickname(editNicknameRequest.getNickname());
        validateUniqueNickname(validNickname);
        member.updateNickname(validNickname);
    }

    private void validateUniqueNickname(Nickname validNickname) {
        if (memberRepository.existsMemberByNickname(validNickname)) {
            throw new DuplicateNicknameException();
        }
    }

    public NicknameResponse findNickname(AuthInfo authInfo) {
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);
        return NicknameResponse.of(member);
    }
}
