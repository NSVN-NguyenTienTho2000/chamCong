package com.thont.common.zother.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DepartmentEnum {
    MARKETING(DepartmentEnum.MAKERTINGStr),
    TECHNOLOGY(DepartmentEnum.TECHNOLOGYStr),
    OFFICE(DepartmentEnum.BACKOFFICEStr);

    private String value;

    public static final String MAKERTINGStr = "CONTENT MARKETING";
    public static final String TECHNOLOGYStr = "TECHNOLOGY";
    public static final String BACKOFFICEStr = "BACK OFFICE";
}
