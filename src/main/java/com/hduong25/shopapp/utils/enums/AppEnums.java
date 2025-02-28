package com.hduong25.shopapp.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: hduong25
 */

@Getter
@AllArgsConstructor
public enum AppEnums implements BaseEnums {
    MALE("MALE", "Nam"),
    FEMALE("FEMALE", "Nữ");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
