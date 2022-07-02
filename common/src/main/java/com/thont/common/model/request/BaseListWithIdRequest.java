package com.thont.common.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class BaseListWithIdRequest extends BaseListRequest{
    @NotBlank(message = "{id.require}")
    private String id;

}
