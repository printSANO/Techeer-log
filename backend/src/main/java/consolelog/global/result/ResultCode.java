package consolelog.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    // Auth
    LOGIN_SUCCESS("A001", "200", "로그인 성공"),


    // Member


    // Post
    FINDBOARD_SUCCESS("B001", "200", "게시글 비회원 조회 성공"),
    FINDPOST_SUCCESS("P001", "200", "게시글 회원 조회 성공"),
    ADDPOST_SUCCESS("P002", "201", "게시글 등록 성공"),
    UPDATEPOST_SUCCESS("P003", "201", "게시글 수정 성공"),
    DELETE_SUCCESS("P004", "200", "게시글 삭제 성공"),
    FINDPOSTLIST_SUCCESS("P005", "200", "게시글 리스트 조회 성공"),
    // Comment

    //Like
    LIKE_SUCCESS("L001", "200", "좋아요 성공");


    private final String code;
    private final String status;
    private final String message;
}
