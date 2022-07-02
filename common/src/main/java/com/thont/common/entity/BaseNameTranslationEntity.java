package com.thont.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@MappedSuperclass
@Where(clause = "deleted = false")
public class BaseNameTranslationEntity extends BaseTranslationEntity {
    @Column(nullable = false)
    @NotNull(message = "{name.require}")
    private String name;

}
