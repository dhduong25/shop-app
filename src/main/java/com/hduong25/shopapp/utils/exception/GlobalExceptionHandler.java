package com.hduong25.shopapp.utils.exception;

import com.hduong25.shopapp.utils.response.ErrorResponse;
import com.hduong25.shopapp.utils.response.ResponseData;
import lombok.Getter;
import org.modelmapper.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: hduong25
 */

@Getter
@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseData.Error> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseData.error(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Server error",
                        ErrorResponse.of(
                                "Global",
                                "Global",
                                "999",
                                e.getMessage()
                        )
                ));
    }

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<ResponseData.Error> handleAppException(ResponseException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ResponseData.error(
                        ex.getStatus().value(),
                        ex.getMessage(),
                        ErrorResponse.of(
                                ex.getLocation(),
                                ex.getMethod(),
                                ex.getErrorCode(),
                                ex.getMessage()
                        )
                ));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(ValidationException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(ex.getMessage()));
    }
}
