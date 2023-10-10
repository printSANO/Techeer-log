package consolelog.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;
import java.util.regex.Pattern;

@Getter
@Embeddable
public class Username {

    private static final Pattern PATTERN = Pattern.compile("^[0-9a-zA-Z]{4,16}$");

    @Column(name = "username")
    private String value;

    protected Username() {
    }

    public Username(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Username username = (Username) o;
        return getValue().equals(username.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
