package consolelog.util.fixture;

import consolelog.auth.dto.LoginRequest;

import static consolelog.util.fixture.MemberFixture.*;

public class AuthFixture {
    public static final LoginRequest VALID_LOGIN_REQUEST = new LoginRequest(VALID_LOGIN_ID_TEXT, VALID_PASSWORD_TEXT);
}
