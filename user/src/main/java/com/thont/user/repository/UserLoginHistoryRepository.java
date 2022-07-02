package com.thont.user.repository;

import com.thont.user.entity.UserLoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginHistoryRepository extends JpaRepository<UserLoginHistory, String> {
    UserLoginHistory getByTokenAndRefreshToken(String token, String refreshToken);
}
