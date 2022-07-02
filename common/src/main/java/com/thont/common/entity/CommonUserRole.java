package com.thont.common.entity;

import com.thont.common.zother.enumeration.RoleEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@Accessors(chain = true)
@MappedSuperclass
public class CommonUserRole extends BaseEntity {

    @Column(nullable = false)
    private RoleEnum role;
}
