package com.thont.common.entity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.MappedSuperclass;

@Data
@Accessors(chain = true)
@MappedSuperclass
public class BaseNameFieldlEntity extends BaseEntity {
}
