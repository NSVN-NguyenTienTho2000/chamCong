package com.thont.user.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
@Table(name="user")
public class Manager extends User{
    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;
    private String phone;
    private String password;
}
