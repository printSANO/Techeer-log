package consolelog.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
@Embeddable
public class loginID {

    private static final Pattern PATTERN = Pattern.compile("^[0-9a-zA-Z]{4,16}$");

    @Column(name = "username")
    private String value;

    protected loginID() {
    }

    public loginID(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        loginID loginID = (loginID) o;
        return getValue().equals(loginID.getValue());
    }


}
