package com.hduong25.shopapp.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author: hduong25
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppConstants {

    public static final String LOCATION = "com.hduong25.shopapp";
    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_TIME_FORMAT_DASH = "dd/MM/yyyy - HH:mm:ss";
    public static final String YYYY_MM_DD_DASH = "yyyy-MM-dd";
    public static final String MM_YYYY_DASH = "MM-yyyy";
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Gender {
        public static final String MALE = "MALE";
        public static final String FEMALE = "FEMALE";

        public static final String REGEX_GENDER = MALE + "|" + FEMALE;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Order {
        public static final String DESC = "DESC";
        public static final String ASC = "ASC";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Role {
        public static final String ADMIN = "ADMIN";
        public static final String EMPLOYEE = "EMPLOYEE";
        public static final String CUSTOMER = "CUSTOMER";

        public static final String REGEX_ROLE = ADMIN + "|" + EMPLOYEE + "|" + CUSTOMER;
    }
}
