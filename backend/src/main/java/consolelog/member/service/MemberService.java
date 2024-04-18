package consolelog.member.service;

import consolelog.auth.domain.encryptor.EncryptorI;
import consolelog.auth.dto.AuthInfo;
import consolelog.global.config.BaseEntity;
import consolelog.image.service.AmazonS3Service;
import consolelog.member.domain.LoginId;
import consolelog.member.domain.Member;
import consolelog.member.domain.Nickname;
import consolelog.member.domain.Password;
import consolelog.member.dto.EditMemberRequest;
import consolelog.member.dto.ProfileResponse;
import consolelog.member.dto.SignupRequest;
import consolelog.member.dto.UniqueResponse;
import consolelog.member.exception.DuplicateNicknameException;
import consolelog.member.exception.InvalidLoginIdException;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.exception.PasswordConfirmationException;
import consolelog.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@Transactional
public class MemberService extends BaseEntity {

    private final MemberRepository memberRepository;
    private final EncryptorI encryptor;
    private final AmazonS3Service amazonS3Service;

    public MemberService(MemberRepository memberRepository, EncryptorI encryptor, AmazonS3Service amazonS3Service) {
        this.memberRepository = memberRepository;
        this.encryptor = encryptor;
        this.amazonS3Service = amazonS3Service;
    }

    @Transactional
    public Member signUp(SignupRequest signupRequest, MultipartFile multipartFile) {
        validate(signupRequest);
        String profileImageUrl = amazonS3Service.upload(signupRequest.getNickname(), multipartFile);
        Member member = Member.builder()
                .loginId(new LoginId(signupRequest.getLoginId()))
                .password(Password.of(encryptor, signupRequest.getPassword()))
                .profileImageUrl(profileImageUrl)
                .nickname(new Nickname(signupRequest.getNickname()))
                .build();
        memberRepository.save(member);
        return member;
    }

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
        validateUniqueLoginId(signupRequest);
    }

    private void validateUniqueLoginId(SignupRequest signupRequest) {
        boolean isDuplicatedLoginId = memberRepository
                .existsMemberByLoginIdValue(signupRequest.getLoginId());
        if (isDuplicatedLoginId) {
            throw new InvalidLoginIdException();
        }
    }

    // else throw 넣어야 함
    private void validateUniqueNickname(SignupRequest signupRequest) {
        boolean isDuplicatedNickname = memberRepository
                .existsMemberByNicknameValue(signupRequest.getNickname());
        if (isDuplicatedNickname) {
            throw new DuplicateNicknameException();
        }
    }

    private void confirmPassword(String password, String passwordConfirmation) {
        if (!password.equals(passwordConfirmation)) {
            throw new PasswordConfirmationException();
        }
    }

    @Transactional
    public void edit(EditMemberRequest editMemberRequest, AuthInfo authInfo, Optional<MultipartFile> multipartFile) {
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);

        multipartFile.ifPresent(file -> {
            if (!file.isEmpty()) {
                String profileImageUrl = amazonS3Service.upload(member.getNickname(), file);
                member.updateProfileImageUrl(profileImageUrl);
            }

        });

        if (editMemberRequest == null) {
            return;
        }

        if (!editMemberRequest.getNickname().isEmpty() && !editMemberRequest.getNickname().equals(member.getNickname())) {
            Nickname validNickname = new Nickname(editMemberRequest.getNickname());
            validateUniqueNickname(validNickname);
            member.updateNickname(validNickname);
        }

        if (!editMemberRequest.getPassword().equals(member.getPassword()) && !editMemberRequest.getPassword().isEmpty()) {
            Password validPassword = Password.of(encryptor, editMemberRequest.getPassword());
            member.updatePassword(validPassword);
        }

        multipartFile.ifPresent(file -> {
            if (!file.isEmpty()) {
                String profileImageUrl = amazonS3Service.upload(editMemberRequest.getNickname(), file);
                member.updateProfileImageUrl(profileImageUrl);
            }
        });
    }

    private void validateUniqueNickname(Nickname validNickname) {
        if (memberRepository.existsMemberByNickname(validNickname)) {
            throw new DuplicateNicknameException();
        }
    }

    public ProfileResponse findProfile(AuthInfo authInfo) {
        Member member = memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);
        return ProfileResponse.of(member);
    }

}
