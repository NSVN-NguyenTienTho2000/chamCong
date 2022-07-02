package com.thont.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HandleFailedWithKnownException extends RuntimeException{
    private String message;
}
