package consolelog.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;
import java.util.regex.Pattern;

@Getter
@Embeddable
public class Password {
    private static final Pattern pattern =
            Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$");

    @Column(name = "password")
    private String value;

    protected Password() {
    }


    public Password(String value) {
        this.value = value;
    }

//    private static void validate(String value) {
//        if (!PATTERN.matcher(value).matches()) {
//            throw new InvalidPasswordFormatException();
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Password password = (Password) o;
        return getValue().equals(password.getValue());
    }

}
