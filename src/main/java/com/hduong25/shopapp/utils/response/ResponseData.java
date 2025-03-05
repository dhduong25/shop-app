package com.hduong25.shopapp.utils.response;

import com.hduong25.shopapp.utils.constants.HttpStatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: hduong25
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> {
    private int code;
    private String message;
    private T data;

    /**
     * Create a success response with default OK status code.
     *
     * @param <T>  The type of the response data
     * @param data The response data
     * @return A Success response object
     */
    public static <T> ResponseData<T> ok(T data) {
        return response(HttpStatusCode.OK, "Success", data);
    }

    /**
     * Create a success response with custom message.
     *
     * @param <T>     The type of the response data
     * @param message Custom success message
     * @param data    The response data
     * @return A Success response object
     */
    public static <T> ResponseData<T> ok(String message, T data) {
        return response(HttpStatusCode.OK, message, data);
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
    public static <T> ResponseData<T> ok(int code, String message, T data) {
        return response(code, message, data);
    }

    public static <T> ResponseData<T> created(String message, T data) {
        return response(HttpStatusCode.CREATED, message, data);
    }

    private static <T> ResponseData<T> response(int code, String message, T data) {
        return new ResponseData<>(code, message, data);
    }
}