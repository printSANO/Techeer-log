package consolelog.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;
import java.util.regex.Pattern;

@Getter
@Embeddable
public class Email {

    private static final Pattern PATTERN = Pattern.compile("^[0-9a-zA-Z]{4,16}$");
    @Column(name = "email")
    private String value;

    protected Email() {
    }

    public Email(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Email email = (Email) o;
        return getValue().equals(email.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
