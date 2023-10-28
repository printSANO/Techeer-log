package consolelog.member.domain;

import consolelog.member.exception.InvalidLoginIdException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
@Embeddable
public class LoginID {

    private static final Pattern PATTERN = Pattern.compile("^[0-9a-zA-Z]{4,16}$");

    @Column(name = "login_id")
    private String value;

    //encryptor  추가해야함
    protected LoginID() {
    }

    private static void validate(String value) {
        if (!PATTERN.matcher(value).matches()) {
            throw new InvalidLoginIdException();
        }
    }

    public LoginID(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoginID loginID = (LoginID) o;
        return getValue().equals(loginID.getValue());
    }


}
