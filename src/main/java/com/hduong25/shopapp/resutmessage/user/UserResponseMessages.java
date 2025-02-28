package com.hduong25.shopapp.resutmessage.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author: hduong25
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseMessages {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Created {
        public static final String CREATED_USER_SUCCESS = "user.create.success";
        public static final String CREATED_USER_ERROR = "user.create.error";
    }
}
