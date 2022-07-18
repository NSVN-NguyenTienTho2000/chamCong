package com.thont.user.business;

import com.github.dozermapper.core.Mapper;
import com.thont.common.exception.CommonChecker;
import com.thont.common.model.request.BaseDetailRequest;
import com.thont.common.model.response.IdResponse;

import com.thont.common.service.HashService;
import com.thont.common.service.JWTService;
import com.thont.common.service.StringService;
import com.thont.common.zother.enumeration.AccStatusEnum;
import com.thont.common.zother.enumeration.RoleEnum;
import com.thont.user.entity.*;
import com.thont.user.model.request.*;
import com.thont.user.model.response.LoginResponse;
import com.thont.user.model.response.MyselfResponse;
import com.thont.user.model.response.UserResponse;
import com.thont.user.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserBusiness {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private Mapper mapper;
    @Autowired
    private HashService hashService;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private StringService stringService;
    @Autowired
    private UserLoginHistoryRepository loginHistoryRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    public Object getMyself(){
        return mapper.map(this.getCurrentUser(), MyselfResponse.class);
    }
    @Transactional
    public IdResponse register(RegisterRequest input) {
        Manager user = managerRepository.save((Manager) new Manager().setPhone(input.getPhone())
                .setPassword(hashService.hash(input.getPassword())).setStaffCode("MNGR" + setNumbers(userRepository.countUser() + 1)));
        userRoleRepository.save((UserRole) new UserRole().setUser(user)
                .setRole(RoleEnum.USER));
        userRepository.save((User) user.setStatus(AccStatusEnum.ACTIVATED));
        return new IdResponse(user.getId());
    }

    public LoginResponse login(LoginRequest input) {
        User user = userRepository.getByPhone(input.getPhone());
        CommonChecker.throwIfFalse(user != null && hashService.check(input.getPassword(), user.getPassword()),
                "user.login.username_or_password_incorrect");
        CommonChecker.throwIfTrue(AccStatusEnum.CREATED.equals(user.getStatus()), "user.login.account.inactive");
        CommonChecker.throwIfTrue(AccStatusEnum.BANNED.equals(user.getStatus()), "user.login.account.banned");
        LoginResponse response = new LoginResponse()
                .setToken(jwtService.generateToken(user))
                .setRefreshToken(stringService.randomString());
        loginHistoryRepository.save(new UserLoginHistory()
                .setUser(user)
                .setToken(response.getToken())
                .setRefreshToken(response.getRefreshToken()));
        return response;
    }

    public String setNumbers(long number) {
        int count = 0;
        long num = number;
        while (num > 0) {
            num /= 10;
            count++;
        }
        String out = "";
        while (6 - count > 0) {
            out = out + "0";
            count++;
        }
        return out + number;
    }

    @Transactional
    public IdResponse createEmployee(CreateEmployeeRequest input) {
        User loginUser = getCurrentUser();
        long number = userRepository.countUser() + 1;
        String staffCode = "TECH" + setNumbers(number);
        User employee = userRepository.save((Employee) mapper.map(input, Employee.class)
                .setManager((Manager) loginUser)
                .setStaffCode(staffCode)
                .setStatus(AccStatusEnum.ACTIVATED));
        return new IdResponse(employee.getId());
    }

    public LoginResponse loginStaff(LoginStaffRequest input) {
        User user = userRepository.getByStaffCode(input.getStaffCode());
        CommonChecker.throwIfFalse(user != null && input.getPassword().equals(user.getPassword()),
                "user.login.username_or_password_incorrect");
        CommonChecker.throwIfTrue(AccStatusEnum.CREATED.equals(user.getStatus()), "user.login.account.inactive");
        CommonChecker.throwIfTrue(AccStatusEnum.BANNED.equals(user.getStatus()), "user.login.account.banned");
        LoginResponse response = new LoginResponse()
                .setToken(jwtService.generateToken(user))
                .setRefreshToken(stringService.randomString());
        loginHistoryRepository.save(new UserLoginHistory()
                .setUser(user)
                .setToken(response.getToken())
                .setRefreshToken(response.getRefreshToken()));
        return response;
    }

    public IdResponse resetPassword(ResetPasswordRequest input) {
        Employee user = employeeRepository.getByStaffCode(input.getStaffCode());
        CommonChecker.throwIfNull(user, "user.notFound");
        userRepository.save(user.setPassword(hashService.hash(input.getPassword())));
        return new IdResponse(user.getId());
    }

    public List getUserInfo() {
        return employeeRepository.getAll().stream()
                .map(item -> new UserResponse()
                        .setId(item.getId())
                        .setStaffCode(item.getStaffCode())
                        .setDateOfBirth(item.getDateOfBirth())
                        .setPhone(item.getPhone())
                        .setAddress(item.getAddress())
                )
                .collect(Collectors.toList());
    }

    public IdResponse updateUser(UpdateUserRequest input) {
        Employee employee = employeeRepository.getById(input.getId());
        CommonChecker.throwIfNull(employee, "user.notFound");
        userRepository.save(employee.setPhone(input.getPhone())
                .setAddress(input.getAddress())
                .setDateOfBirth(input.getDateOfBirth())
                .setFullName(input.getFullName())
                .setAvatar(input.getAvatar()));
        return new IdResponse(employee.getId());
    }
    public UserResponse getEmployeeById(BaseDetailRequest input) {
        Employee employee = employeeRepository.getById(input.getId());
        return new UserResponse()
                .setId(employee.getId())
                .setStaffCode(employee.getStaffCode())
                .setAddress(employee.getAddress())
                .setPhone(employee.getPhone())
                .setDateOfBirth(employee.getDateOfBirth());
    }

}
