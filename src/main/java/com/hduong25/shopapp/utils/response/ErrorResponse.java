package com.hduong25.shopapp.utils.response;

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
public class ErrorResponse {
    private String location;
    private String method;
    private String errorCode;
    private String message;

    public static ErrorResponse of(String message) {
        return ErrorResponse.builder()
                .message(message)
                .build();
    }

    public static ErrorResponse of(String location, String method, String errorCode, String message) {
        return ErrorResponse.builder()
                .location(location)
                .method(method)
                .errorCode(errorCode)
                .message(message)
                .build();
    }
}
