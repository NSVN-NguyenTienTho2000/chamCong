package com.thont.user.zother.config;

import com.thont.common.service.StringService;
import com.thont.common.zother.config.JWTFilterAbstract;
import com.thont.user.repository.UserRepository;
import com.thont.user.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class JWTFilter extends JWTFilterAbstract {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StringService stringService;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    protected UserDetails getUserWithRoleById(String id) {
        return userRepository.getUserWithRoleById(id);
    }



}
