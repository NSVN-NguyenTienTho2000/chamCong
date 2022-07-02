package com.thont.user.entity;

import com.thont.common.entity.CommonDepartment;
import com.thont.common.zother.enumeration.DepartmentEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Table(name = "department")
@Accessors(chain = true)
public class Department extends CommonDepartment {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
