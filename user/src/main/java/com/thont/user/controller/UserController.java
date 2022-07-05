package com.thont.user.controller;
import com.thont.common.model.response.IdResponse;
import com.thont.user.business.UserBusiness;
import com.thont.user.model.request.*;
import com.thont.user.model.response.LoginResponse;
import com.thont.user.model.response.MyselfResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user/api")
public class UserController {
    @Autowired
    private UserBusiness userBusiness;

    @PostMapping("/register")
    public IdResponse register(@Valid @RequestBody RegisterRequest input){
        return userBusiness.register(input);
    }
    @PostMapping("/manger/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest input){
        return userBusiness.login(input);
    }
    @PostMapping("/create-employee")
    public IdResponse createEmployee(@Valid @RequestBody CreateEmployeeRequest input){
        return userBusiness.createEmployee(input);
    }
    @PostMapping("/staff/login")
    public LoginResponse loginStaff(@Valid @RequestBody LoginStaffRequest input){
        return userBusiness.loginStaff(input);
    }
    @PostMapping("/password/reset")
    public IdResponse resetPassword(@Valid @RequestBody ResetPasswordRequest input){
        return userBusiness.resetPassword(input);
    }
    @GetMapping("/list-user")
    public List getUserInfo(){
        return userBusiness.getUserInfo();
    }
    @PostMapping("/update-user")
    public IdResponse updateUser(@Valid @RequestBody UpdateUserRequest input){
        return userBusiness.updateUser(input);
    }
    @GetMapping("/get-myself")
    public Object getMyself(){
        return userBusiness.getMyself();
    }

}
