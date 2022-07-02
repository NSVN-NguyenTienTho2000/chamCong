package com.thont.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thont.common.entity.CommonUser;

import com.thont.common.zother.enumeration.DepartmentEnum;
import com.thont.common.zother.enumeration.RoleEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.NotImplementedException;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Accessors(chain = true)
@Where(clause = "deleted = false")
@Table(name = "user",
uniqueConstraints = @UniqueConstraint(columnNames = {"phone", "rndu","staffCode"}))
public class User extends CommonUser {
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserRole> roles;

    @JsonIgnore
    public List<RoleEnum> getRolesEnum(){
        if(this.roles != null){
            return this.roles.stream().map(item -> item.getRole()).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private Department department;
    @JsonIgnore
    public DepartmentEnum getDepartmentEnum(){
        if(this.department != null){
            return this.department.getDepartment();
        }
        return null;
    }
    private String fullName;
    private String avatar;
    private String staffCode;

    @Override
    public String getPassword() {
        throw new NotImplementedException();
    }
}
