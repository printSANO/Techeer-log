package consolelog.util.fixture;

import consolelog.auth.dto.AuthInfo;
import consolelog.auth.dto.LoginRequest;

import static consolelog.util.fixture.MemberFixture.*;

public class AuthFixture {
    public static final LoginRequest VALID_LOGIN_REQUEST = new LoginRequest(VALID_LOGIN_ID_TEXT, VALID_PASSWORD_TEXT);
    public static final LoginRequest INVALID_LOGIN_REQUEST_1 = new LoginRequest(VALID_LOGIN_ID_TEXT, INVALID_PASSWORD_TEXT);
    public static final LoginRequest INVALID_LOGIN_REQUEST_2 = new LoginRequest(INVALID_LOGIN_ID_TEXT, INVALID_PASSWORD_TEXT);
    public static final AuthInfo VALID_AUTH_INFO = new AuthInfo(1L, "user", "m1");

}
