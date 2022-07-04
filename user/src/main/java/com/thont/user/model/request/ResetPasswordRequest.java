package com.thont.user.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class ResetPasswordRequest {
    @NotBlank(message = "staff_code.require")
    @Size(min = 10, max = 10, message = "{staff_code.10character}")
    private String staffCode;
    @NotBlank(message = "{user.password.require}")
    @Size(min = 8, max = 256, message = "{password.invalid}")
    private String password;
}
