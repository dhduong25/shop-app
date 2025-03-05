package com.hduong25.shopapp.utils.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author: hduong25
 */

@Getter
public class ResponseException extends RuntimeException {
    private final HttpStatus status;
    private final String location;
    private final String method;
    private final String errorCode;

    public ResponseException(HttpStatus status, String location, String method, String errorCode, String message) {
        super(message);
        this.status = status;
        this.location = location;
        this.method = method;
        this.errorCode = errorCode;
    }

    public ResponseException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
        this.location = "Shop app";
        this.method = "Global";
        this.errorCode = "999";
    }

    // Factory method để tạo exception nhanh hơn
    public static ResponseException of(HttpStatus status, String location, String method, String errorCode, String message) {
        return new ResponseException(status, location, method, errorCode, message);
    }
}
