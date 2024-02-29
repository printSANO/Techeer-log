package consolelog.global.support;

public final class ConstantString {
    public static final String BEARER_STRING = "Bearer ";
    public static final String REFRESH_TOKEN_STRING = "Refresh-Token";
    public static final String ACCESS_TOKEN_STRING = "Access-Token";

    // 외부에서 실수로 생성자를 통해 객체를 만드는 것을 방지
    private ConstantString() {}
}
