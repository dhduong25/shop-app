package com.hduong25.shopapp.utils.response;

import com.hduong25.shopapp.utils.constants.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: hduong25
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse<T> {
    private String location;
    private String method;
    private String code;
    private T errorDetails;

    public static <T> ErrorResponse<T> error(String location, String method, String code, T data) {
        return response(location, method, code, data);
    }

    public static <T> ErrorResponse<T> error(T data) {
        return response(AppConstants.LOCATION, "", "", data);
    }

    private static <T> ErrorResponse<T> response(String location, String method, String code, T data) {
        return new ErrorResponse<>(location, method, code, data);
    }
}
