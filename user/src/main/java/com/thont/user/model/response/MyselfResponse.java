package com.thont.user.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MyselfResponse {
    private String id;
    private String phone;
    private String staffCode;
    private String fullName;

}
