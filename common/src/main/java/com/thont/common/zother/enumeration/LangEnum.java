package com.thont.common.zother.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Locale;

@Getter
@AllArgsConstructor
public enum LangEnum {
    EN("en-us"),
    VI("vi-vn");
    private String value;

    public static LangEnum fromLocale(Locale locale) {
        return LangEnum.fromLocale(locale, LangEnum.EN);
    }

    public static LangEnum fromLocale(Locale locale, LangEnum defaultValue) {
        for (LangEnum val : LangEnum.values()) {
            if (val.getValue().equals(locale.toString().toLowerCase(Locale.ROOT).replace('_', '-'))) {
                return val;
            }
        }
        return defaultValue;
    }
}
