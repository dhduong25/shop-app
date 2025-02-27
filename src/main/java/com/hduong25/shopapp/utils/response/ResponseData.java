package com.hduong25.shopapp.utils.response;

import com.hduong25.shopapp.utils.constants.HttpStatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: hduong25
 */

@Getter
@Setter
@NoArgsConstructor
public class ResponseData {
    private int code;
    private String message;

    protected ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Create a success response with default OK status code.
     *
     * @param <T>  The type of the response data
     * @param data The response data
     * @return A Success response object
     */
    public static <T> Success<T> ok(T data) {
        return new Success<>(HttpStatusCode.OK, "Success", data);
    }

    /**
     * Create a success response with custom message.
     *
     * @param <T>     The type of the response data
     * @param message Custom success message
     * @param data    The response data
     * @return A Success response object
     */
    public static <T> Success<T> ok(String message, T data) {
        return new Success<>(HttpStatusCode.OK, message, data);
    }

    /**
     * Create a success response with custom status code and message.
     *
     * @param <T>     The type of the response data
     * @param code    Custom HTTP status code
     * @param message Custom success message
     * @param data    The response data
     * @return A Success response object
     */
    public static <T> Success<T> ok(int code, String message, T data) {
        return new Success<>(code, message, data);
    }

    /**
     * Create an error response with default BAD_REQUEST status code.
     *
     * @param errorDetails Details about the error
     * @return An Error response object
     */
    public static Error error(ErrorResponse errorDetails) {
        return new Error(HttpStatusCode.BAD_REQUEST, "Error", errorDetails);
    }

    /**
     * Create an error response with custom status code.
     *
     * @param code         Custom HTTP status code
     * @param message      Custom error message
     * @param errorDetails Details about the error
     * @return An Error response object
     */
    public static Error error(int code, String message, ErrorResponse errorDetails) {
        return new Error(code, message, errorDetails);
    }

    @Getter
    public static class Success<T> extends ResponseData {
        private final T data;

        public Success(int code, String message, T data) {
            super(code, message);
            this.data = data;
        }
    }

    /**
     * Represents an API error response that contains error details.
     */
    @Getter
    public static class Error extends ResponseData {
        private final ErrorResponse errorResponse;

        public Error(int code, String message, ErrorResponse error) {
            super(code, message);
            this.errorResponse = error;
        }
    }
}