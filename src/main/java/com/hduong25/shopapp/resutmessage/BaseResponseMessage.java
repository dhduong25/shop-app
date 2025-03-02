package com.hduong25.shopapp.resutmessage;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: hduong25
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseResponseMessage {

    public static final String GENDER_INVALID = "Giới tính không hợp lệ!";
    public static final String EMAIL_INVALID = "Email không hợp lệ!";
    public static final String SIZE_MAX = " vượt quá ký tự cho phép";

}
