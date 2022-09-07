package com.amin.dev.customer.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomerExceptionHandler {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(CustomerExceptionHandler.class);

    @ExceptionHandler(value =
            ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException ae) {
        ApiException apiException =
                new ApiException(ae.getMessage(),
                        ae,
                        HttpStatus.BAD_REQUEST,
                        ZonedDateTime.now());
        return new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value =
            CustomerNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(CustomerNotFoundException ae) {
        ApiException apiException =
                new ApiException(ae.getMessage(),
                        ae,
                        HttpStatus.NOT_FOUND,
                        ZonedDateTime.now());
        return new ResponseEntity<>(
                apiException,
                HttpStatus.NOT_FOUND);
    }
}
