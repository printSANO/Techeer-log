package consolelog.util.fixture;

import consolelog.auth.domain.encryptor.EncryptorFactory;
import consolelog.auth.domain.encryptor.EncryptorI;
import consolelog.member.domain.LoginId;
import consolelog.member.domain.Member;
import consolelog.member.domain.Nickname;
import consolelog.member.domain.Password;

public class MemberFixture {
    public static final EncryptorI ENCRYPTOR = new EncryptorFactory().getEncryptor();

    public static final String VALID_LOGIN_ID_TEXT = "m1";
    public static final LoginId VALID_LOGIN_ID = new LoginId(VALID_LOGIN_ID_TEXT);

    public static final String VALID_PASSWORD_TEXT = "1q2w3e4r!";
    public static final Password VALID_PASSWORD = Password.of(ENCRYPTOR, VALID_PASSWORD_TEXT);

    public static final String VALID_NICKNAME_TEXT = "n1";
    public static final Nickname VALID_NICKNAME = new Nickname(VALID_NICKNAME_TEXT);

    public static final String VALID_PROFILE_IMAGE_URL = "";

    public static Member M1 = Member.builder()
            .id(1L)
            .loginId(VALID_LOGIN_ID)
            .password(VALID_PASSWORD)
            .nickname(VALID_NICKNAME)
            .profileImageUrl(VALID_PROFILE_IMAGE_URL)
            .build();

    public static Member M2 = Member.builder()
            .id(2L)
            .loginId(new LoginId("m2"))
            .password(VALID_PASSWORD)
            .nickname(new Nickname("n2"))
            .profileImageUrl(VALID_PROFILE_IMAGE_URL)
            .build();

}
