package com.thont.user.zother.enumeration;

import lombok.Getter;

@Getter
public enum OTPTypeEnum {
    REGISTER_USER("REGISTER_USER"),
    RESET_PASSWORD("RESET_PASSWORD");

    OTPTypeEnum(String value) {
        this.value = value;
    }

    private String value;

}
