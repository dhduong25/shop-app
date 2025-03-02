package com.hduong25.shopapp.resutmessage.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author: hduong25
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseMessages {

    public static final String USER_WITH_ID_NOT_FOUND = "user.with.id.notfound";
    public static final String USER_DUPLICATE_EMAIL = "user.duplicate.email";

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Created {
        public static final String CREATED_USER_SUCCESS = "user.create.success";
        public static final String CREATED_USER_ERROR = "user.create.error";
    }
}
