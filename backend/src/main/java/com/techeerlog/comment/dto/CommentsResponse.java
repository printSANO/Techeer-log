package com.techeerlog.comment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

// 여러 댓글 정보와 그 총 개수를 함께 전달하기 위한 DTO >> 여러 댓글 목록과 그 총 개수를 클라이언트로 전송할 때 사용
@Getter
@Setter
public class CommentsResponse {

    private List<CommentResponse> comments;
    private int totalCount;

    public CommentsResponse() {
    }

    public CommentsResponse(List<CommentResponse> comments, int totalCount) {
        this.comments = comments;
        this.totalCount = totalCount;
    }
}
