package com.techeerlog.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
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
}
