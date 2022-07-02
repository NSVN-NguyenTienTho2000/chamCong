package com.thont.user.model.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class RegisterRequest {
    @NotBlank
    @Size(min = 10, max = 10)
    private String phone;
    @NotBlank(message = "password is required")
    @Size(min = 8, max = 256, message = "password is invalid")
    private String password;
}
