package com.thont.common.entity;

import com.thont.common.zother.enumeration.DepartmentEnum;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@Accessors(chain = true)
@MappedSuperclass
public class CommonDepartment extends BaseEntity {

    @Column(nullable = false)
    private DepartmentEnum department;
}

