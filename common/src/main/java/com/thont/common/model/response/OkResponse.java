package com.thont.common.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OkResponse {
    private Object data;
    private String message;

}
