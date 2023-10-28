package consolelog.auth.service;

import consolelog.auth.domain.encryptor.EncryptorI;
import consolelog.auth.dto.AuthInfo;
import consolelog.auth.dto.LoginRequest;
import consolelog.auth.exception.LoginFailedException;
import consolelog.member.domain.Member;
import consolelog.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final MemberRepository memberRepository;
    private final EncryptorI encryptor;

    public AuthService(MemberRepository memberRepository, EncryptorI encryptor) {
        this.memberRepository = memberRepository;
        this.encryptor = encryptor;
    }

    public AuthInfo login(LoginRequest loginRequest) {
        String loginId = encryptor.encrypt(loginRequest.getLoginId());
        String password = encryptor.encrypt(loginRequest.getPassword());
        Member member = memberRepository.findByLoginIdValueAndPasswordValue(loginId, password)
                .orElseThrow(LoginFailedException::new);
        return new AuthInfo(member.getId(), member.getRoleType().getName(), member.getNickname());
    }
}
