package consolelog.member.domain;

import consolelog.auth.domain.encryptor.EncryptorI;
import consolelog.member.exception.InvalidLoginIdException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
@Embeddable
public class LoginId {

    @Column(name = "login_id")
    private String value;

    //encryptor  추가해야함
    protected LoginId() {
    }

    public LoginId(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoginId loginId = (LoginId) o;
        return getValue().equals(loginId.getValue());
    }


}
