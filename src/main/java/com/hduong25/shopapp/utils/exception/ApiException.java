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

    public ApiException(String message) {
        super(message);
        this.status = null;
        this.location = null;
        this.method = null;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.status = null;
        this.location = null;
        this.method = null;
    }

    public ApiException(Throwable cause) {
        super(cause);
        this.status = null;
        this.location = null;
        this.method = null;
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
