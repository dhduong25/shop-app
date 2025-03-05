package com.hduong25.shopapp.utils.exception;

import com.hduong25.shopapp.utils.constants.AppConstants;
import com.hduong25.shopapp.utils.response.ErrorResponse;
import lombok.Getter;
import org.hibernate.PropertyValueException;
import org.modelmapper.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: hduong25
 */

@Getter
@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(ResponseException.class)
    public ErrorResponse<String> handleAppException(ResponseException ex) {
        return ErrorResponse.error(
                ex.getLocation(),
                ex.getMethod(),
                ex.getErrorCode(),
                ex.getLocalizedMessage()
        );
    }

    @ExceptionHandler(ApiException.class)
    public ErrorResponse<String> handleApiException(ApiException e) {
        return ErrorResponse.error(
                e.getLocation(),
                e.getMethod(),
                "",
                e.getLocalizedMessage()
        );
    }

    @ExceptionHandler(ValidationException.class)
    public ErrorResponse<String> handleValidation(ValidationException ex) {
        return ErrorResponse.error(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errorsMap = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        error -> Optional.ofNullable(error.getDefaultMessage()).orElse(""),
                        (v1, v2) -> v1
                ));

        return ErrorResponse.error(
                AppConstants.LOCATION,
                "",
                "",
                errorsMap
        );
    }

    @ExceptionHandler(PropertyValueException.class)
    public ErrorResponse<String> handlePropertyValueException(PropertyValueException ex) {
        return ErrorResponse.error(
                AppConstants.LOCATION,
                "On Entity",
                "",
                ex.getLocalizedMessage()
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorResponse<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ErrorResponse.error(
                AppConstants.LOCATION,
                "On Entity",
                "",
                ex.getLocalizedMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse<String> handleException(Exception e) {
        return ErrorResponse.error(
                AppConstants.LOCATION,
                "Exception",
                "",
                e.getLocalizedMessage()
        );
    }
}
