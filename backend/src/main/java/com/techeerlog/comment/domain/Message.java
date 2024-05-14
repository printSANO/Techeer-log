package com.techeerlog.comment.domain;


import com.techeerlog.comment.exception.InvalidMessageException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;


@Getter
@Embeddable
public class Message {

    private static final int MAX_MESSAGE_LENGTH = 255;

    @Column(name = "message", nullable = false)
    private String value;

    protected Message() {
    }

    public Message(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.isBlank() || value.length() > MAX_MESSAGE_LENGTH) {
            throw new InvalidMessageException();
        }
    }
}
