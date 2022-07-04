package com.thont.user.model.response;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@Accessors(chain = true)
public class UserResponse {
    private String id;
    private String staffCode;
    private String phone;
    private String address;
    private String dateOfBirth;
}
