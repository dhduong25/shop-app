package com.hduong25.shopapp.utils;

import com.hduong25.shopapp.utils.constants.AppConstants;
import com.hduong25.shopapp.utils.enums.AppEnums;
import com.hduong25.shopapp.utils.enums.StatusEnums;
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

    public static String getStatus(String code) {
        return switch (code) {
            case AppConstants.Status.ACTIVE -> StatusEnums.ACTIVE.getDesc();
            case AppConstants.Status.INACTIVE -> StatusEnums.INACTIVE.getDesc();
            case AppConstants.Status.OrderStatus.PENDING ->
                    StatusEnums.PENDING.getDesc();
            default -> "";
        };
    }
}
