package com.hduong25.shopapp.utils.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Custom API Exception for handling application-specific errors.
 * Author: hduong25
 */
@Getter
public class ApiException extends RuntimeException {
    private final HttpStatus status;
    private final String location;
    private final String method;

    private static final String L = "com.hduong25.shopapp";
    private static final String M = "API Exception";

    public ApiException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
        this.location = L;
        this.method = M;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.status = HttpStatus.BAD_REQUEST;
        this.location = L;
        this.method = M;
    }

    public ApiException(Throwable cause) {
        super(cause);
        this.status = HttpStatus.BAD_REQUEST;
        this.location = L;
        this.method = M;
    }

    public ApiException(String message, HttpStatus status, String location, String method) {
        super(message);
        this.status = status;
        this.location = location;
        this.method = method;
    }

    public ApiException(String message, HttpStatus status, String location, String method, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.location = location;
        this.method = method;
    }
}
