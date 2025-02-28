package com.hduong25.shopapp.utils;

import com.hduong25.shopapp.utils.enums.AppEnums;
import lombok.experimental.UtilityClass;

/**
 * @author: hduong25
 */

@UtilityClass
public class CommonUtils {

    public static String getGender(String code) {
        return code.equals(AppEnums.MALE.getValue())
                ? AppEnums.MALE.getDesc()
                : AppEnums.FEMALE.getDesc();
    }
}
