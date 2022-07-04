package com.thont.user.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class UpdateUserRequest {
    private String id;
    private String avatar;
    @Size(min = 1, max = 256)
    private String fullName;
    @Size(min = 10, max = 10)
    private String phone;
    private String address;
    private String dateOfBirth;
}
