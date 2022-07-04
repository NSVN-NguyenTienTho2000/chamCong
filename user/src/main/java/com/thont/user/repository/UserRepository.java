package com.thont.user.repository;



import com.thont.user.entity.Employee;
import com.thont.user.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select user from User user where user.id = :id")
    User getById(String id);

    @Query("select user from User user left join fetch user.roles where user.id = :id")
    User getUserWithRoleById(String id);
    @Query("select manager from Manager manager where manager.phone = :phone")
    User getByPhone(String phone);
    @Query(value = "select count(*) from  chamcong.user",nativeQuery = true)
    Long countUser();
    @Query("select user from User user where user.staffCode = :code")
    Employee getByStaffCode(String code);
    @Query("select user from User user")
    List<User> getAll();


}
