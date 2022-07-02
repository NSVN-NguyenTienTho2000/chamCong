package com.thont.common.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BaseDetailRequest {
    @NotBlank(message = "{base.id.require}")
    private String id;
}
