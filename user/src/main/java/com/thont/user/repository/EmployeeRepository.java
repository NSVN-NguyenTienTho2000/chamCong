package com.thont.user.repository;

import com.thont.user.entity.Employee;
import com.thont.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "select * from user where staff_code = :code", nativeQuery = true)
    Employee getByStaffCode(String code);


    @Query("select employee from Employee employee")
    List<Employee> getAll();
    @Query("select employee from Employee employee where employee.id=:id")
    Employee getById(String id);
}
