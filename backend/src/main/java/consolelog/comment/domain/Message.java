package consolelog.comment.domain;


import consolelog.comment.exception.InvalidMessageException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Message {

    private static final int MAX_MESSAGE_LEGTH = 500;

    @Column(name = "message", nullable = false)
    private String value;

    protected Message() {
    }

    public Message(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new InvalidMessageException();
        }
        if (value.length() > MAX_MESSAGE_LEGTH) {
            throw new InvalidMessageException();
        }
    }
}
