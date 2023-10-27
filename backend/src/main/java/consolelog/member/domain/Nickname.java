package consolelog.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;
import java.util.regex.Pattern;

@Getter
@Embeddable
public class Nickname {

    private static final Pattern PATTERN = Pattern.compile("^[0-9a-zA-Z가-힣]+(?:\\s+[0-9a-zA-Z가-힣]+)*$");
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 16;

    @Column(name = "nickname", unique = true)
    private String value;

    protected Nickname() {
    }

    public Nickname(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Nickname nickname = (Nickname) o;
        return getValue().equals(nickname.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}