package consolelog.post.exception;

import consolelog.advice.NotFoundException;

public class PostNotFoundException extends NotFoundException {
    private static final String MESSAGE = "해당 게시글을 찾을 수 없습니다.";

    public PostNotFoundException() {
        super(MESSAGE);
    }
}
