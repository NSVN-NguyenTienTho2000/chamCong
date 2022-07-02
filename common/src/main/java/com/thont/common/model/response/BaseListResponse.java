package com.thont.common.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class BaseListResponse {
    private Object data;
    private long total;
}
