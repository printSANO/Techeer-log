package consolelog.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    // Auth
    LOGIN_SUCCESS("A001", "200", "로그인 성공"),
    REFRESH_SUCCESS("A002", "204", "access token 재발급 성공"),
    LOGOUT_SUCCESS("A003", "200", "로그아웃 성공"),

    // Member


    // Post


    // Comment
    COMMENT_CREATED_SUCCESS("C001", "201", "댓글 등록 성공"),
    COMMENT_REPLY_CREATED_SUCCESS("C002", "201", "대댓글 등록 성공"),
    UPDATE_COMMENT_SUCCESS("C003", "201", "댓글 수정 성공"),
    DELETE_COMMENT_SUCCESS("C004", "200", "댓글 삭제 성공"),
    GET_COMMENT_SUCCESS("C005", "200", "댓글 조회 성공"),
    //Like
    LIKE_CREATED_SUCCESS("L001", "201", "좋아요 성공");


    private final String code;
    private final String status;
    private final String message;
}
