package com.thont.common.entity;

import com.thont.common.zother.enumeration.AccStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
@MappedSuperclass
@SQLDelete(sql = "update user set deleted = false where id = ?")
public abstract class CommonUser extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String rndu = "na"; // not answer

    private AccStatusEnum status = AccStatusEnum.CREATED;

    protected abstract List<? extends CommonUserRole> getRoles();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles() != null ? getRoles()
                .stream()
                .map(item ->
                        new SimpleGrantedAuthority(item
                                .getRole()
                                .getValue()))
                .collect(Collectors.toList()) : new LinkedList<>();
    }

    @Override
    public String getUsername() {
        return getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
