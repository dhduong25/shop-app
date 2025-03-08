package com.hduong25.shopapp.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: hduong25
 */

@Getter
@AllArgsConstructor
public enum StatusEnums implements BaseEnums {
    ACTIVE("ACTIVE", "Hoạt động"),
    INACTIVE("INACTIVE", "Không hoạt động"),
    PENDING("PENDING", "Chờ xác nhận");

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
