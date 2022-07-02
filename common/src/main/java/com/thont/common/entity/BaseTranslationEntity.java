package com.thont.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thont.common.zother.enumeration.LangEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@MappedSuperclass
@Where(clause = "deleted = false")
public class BaseTranslationEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private boolean deleted = false;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @JsonIgnore
    @Column(name = "created_by")
    private String createdBy;
    @JsonIgnore
    @Column(name = "updated_by")
    private String updatedBy;
    @JsonIgnore
    @Column(nullable = false)
    private LangEnum language = LangEnum.EN;

    @PrePersist
    private void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof CommonUser) {
            this.createdBy = ((CommonUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        }
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
        if (SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof CommonUser) {
            this.updatedBy = ((CommonUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        }
    }
}
