package com.thont.user.zother.enumeration;

import lombok.Getter;

@Getter
public enum EmailEnum {
    REGEX("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");

    private EmailEnum(String value) {
        this.value = value;
    }
    private String value;
}
