package consolelog.support.token;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;

import java.util.Enumeration;

public class AuthorizationExtractor {
    public static final String BEARER_TYPE = "Bearer";

    private AuthorizationExtractor() {
    }

    public static String extractAccessToken(HttpServletRequest request) {
        //  request.getHeaders() 반환값이 Enumeration 인데,
        //  Enumeration 보다 Iterator 를 쓰는 편이 좋다고 해서 굳이 Type Casting 까지 해서 Iterator 로 써야 할까?
        Enumeration<String> headers = request.getHeaders(HttpHeaders.AUTHORIZATION);
        return extract(headers);
    }

    public static String extractRefreshToken(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaders("Refresh-Token");
        return extract(headers);
    }

    private static String extract(Enumeration<String> headers) {
        while (headers.hasMoreElements()) {
            String value = headers.nextElement();
            if (value.toLowerCase().startsWith(BEARER_TYPE.toLowerCase())) {
                String authHeaderValue = value.substring(BEARER_TYPE.length()).trim();

                int commaIdx = authHeaderValue.indexOf(',');
                if (commaIdx > 0) {
                    authHeaderValue = authHeaderValue.substring(0, commaIdx);
                }
                return authHeaderValue;
            }
        }
        return null;
    }

}
