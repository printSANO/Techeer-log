package consolelog.post.exception;

import consolelog.global.advice.NotFoundException;

public class PostNotFoundException extends NotFoundException {
    private static final String MESSAGE = "해당 게시글을 찾을 수 없습니다.";

    public PostNotFoundException() {
        super(MESSAGE);
    }
}
