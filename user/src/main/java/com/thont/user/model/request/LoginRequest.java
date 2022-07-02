package com.thont.user.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class LoginRequest {
    @NotBlank(message = "{user.phone.require}")
//    @Email(message = "email is not valid")
    private String phone;
    @NotBlank(message = "{user.password.require}")
    @Size(min = 8, max = 256)
    private String password;
}
