package com.thont.common.zother.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {
    ADMIN(RoleEnum.ADMINStr),
    EDITOR(RoleEnum.CEDITORStr),
    USER(RoleEnum.USERStr);

    private String value;

    public static final String ADMINStr = "ADMIN";
    public static final String CEDITORStr = "CEDITOR";
    public static final String USERStr = "USER";
}
