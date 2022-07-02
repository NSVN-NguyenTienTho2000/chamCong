package com.thont.user.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginStaffRequest {
    private String staffCode;
    private String password;
}
