package com.thont.user.entity;


import com.thont.common.entity.CommonUserRole;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_role")
@Accessors(chain = true)
public class UserRole extends CommonUserRole {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
