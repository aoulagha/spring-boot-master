package com.amin.dev.customer.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus status;
    private final ZonedDateTime dTime;

    public ApiException(String message, Throwable throwable, HttpStatus status, ZonedDateTime dTime) {
        this.message = message;
        this.throwable = throwable;
        this.status = status;
        this.dTime = dTime;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ZonedDateTime getdTime() {
        return dTime;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "message='" + message + '\'' +
                ", throwable=" + throwable +
                ", status=" + status +
                ", dTime=" + dTime +
                '}';
    }
}
