package consolelog.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    COMMENT_CREATED_SUCCESS("C001", "201", "댓글이 정상적으로 등록되었습니다."),
    COMMENT_REPLY_CREATED_SUCCESS("C002", "201", "대댓글이 정상적으로 등록되었습니다."),
    UPDATE_COMMENT_SUCCESS("C003", "201", "댓글이 정상적으로 수정되었습니다."),
    DELETE_COMMENT_SUCCESS("C004", "200", "댓글이 정상적으로 삭제되었습니다."),
    GET_COMMENT_SUCCESS("C005", "200", "댓글이 정상적으로 출력되었습니다.");

    private final String code;
    private final String status;
    private final String message;
}
