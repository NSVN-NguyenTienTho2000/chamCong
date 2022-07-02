package com.thont.common.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class FailedResponse implements BaseResponse {
    private List<Pair> errors;
    private String message;
}
