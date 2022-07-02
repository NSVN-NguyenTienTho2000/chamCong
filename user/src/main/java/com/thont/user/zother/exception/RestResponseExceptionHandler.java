package com.thont.user.zother.exception;

import com.thont.common.exception.HandleFailedWithKnownException;
import com.thont.common.model.response.BaseResponse;
import com.thont.common.model.response.FailedResponse;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ex.printStackTrace();
        return ResponseEntity
                .badRequest()
                .body(new FailedResponse()
                        .setErrors(ex.getAllErrors()
                                .stream()
                                .map(item -> {
                                    if (item instanceof FieldError) {
                                        return new BaseResponse.Pair(((FieldError) item).getField(), item.getDefaultMessage());
                                    }
                                    return new BaseResponse.Pair("", "");
                                })
                                .collect(Collectors.toList())));
    }

    @ExceptionHandler(HandleFailedWithKnownException.class)
    public ResponseEntity<Object> handleFailedDueToKnownException(HandleFailedWithKnownException ex, HttpServletRequest request) {
        return ResponseEntity
                .badRequest()
                .body(new FailedResponse()
                        .setMessage(messageSource.getMessage(ex.getMessage(), null, request.getLocale())));
    }

//    @ExceptionHandler(EntityNotFoundException.class)
//    private ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
//        ex.printStackTrace();
//        return ResponseEntity.ok(ex.getMessage());
//    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Object> handleTokenTimeoutException(ExpiredJwtException ex) {
        return ResponseEntity.status(HttpStatus.GONE).body("token timeout");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handlePermissionDenied(AccessDeniedException ex){
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("permission denied");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnknownException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity
                .internalServerError()
                .body(new FailedResponse()
                        .setMessage("unknown error happened. please contact admin"));
    }
}
