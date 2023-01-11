package com.interbanking.bank.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Collections;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<ErrorApi> handleMethodArgumentTypeMismatchException(Exception exception) {
        log.error("Exception. Please, see the following stacktrace: ", exception);
        ErrorApi apiError = new ErrorApi(HttpStatus.BAD_REQUEST, "Type argument not valid", Collections.singletonList(exception.getMessage()));
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}