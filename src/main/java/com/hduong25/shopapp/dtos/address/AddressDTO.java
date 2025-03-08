package com.hduong25.shopapp.dtos.address;

import com.hduong25.shopapp.dtos.base.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: hduong25
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO chứa thông tin địa chỉ")
public class AddressDTO extends BaseDTO {
    @Schema(description = "Mã bản ghi địa chỉ", example = "01")
    private String code;

    @Schema(description = "Tên bản ghi địa chỉ", example = "ABC")
    private String name;

    @Schema(description = "Mã bản ghi địa chỉ cha", example = "02")
    private String parentCode;
}
