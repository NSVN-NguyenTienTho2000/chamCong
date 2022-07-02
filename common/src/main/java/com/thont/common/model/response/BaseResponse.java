package com.thont.common.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

public interface BaseResponse {
    @Data
    @Accessors(chain = true)
    @AllArgsConstructor
    public class Pair{
        private String key;
        private String value;
    }

    default String getModule(){
        return "module.user";
    }
}
