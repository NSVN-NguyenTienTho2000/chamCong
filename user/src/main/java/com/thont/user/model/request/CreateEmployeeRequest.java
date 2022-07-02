package com.thont.user.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateEmployeeRequest {
    private String fullName;
    private String dateOfBirth;
    private String address;
}
