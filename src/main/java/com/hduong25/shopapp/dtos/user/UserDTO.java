package com.hduong25.shopapp.dtos.user;

import com.hduong25.shopapp.dtos.base.BaseDTO;
import com.hduong25.shopapp.utils.constants.AppConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.hduong25.shopapp.responsemessage.BaseResponseMessage.EMAIL_INVALID;
import static com.hduong25.shopapp.responsemessage.BaseResponseMessage.GENDER_INVALID;
import static com.hduong25.shopapp.responsemessage.BaseResponseMessage.ROLE_INVALID;
import static com.hduong25.shopapp.responsemessage.BaseResponseMessage.SIZE_MAX;

/**
 * @author: hduong25
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO chứa thông tin của người dùng")
public class UserDTO extends BaseDTO {
    @Schema(description = "Tên người dùng", example = "Do Hong Duong")
    private String name;

    @Email(message = EMAIL_INVALID)
    @Size(max = 100, message = "Email" + SIZE_MAX)
    @Schema(description = "Email người dùng", example = "hduong25@gmail.com")
    private String email;

    @Schema(description = "Số điện thoại người dùng", example = "0987654321")
    private String phone;

    @Schema(description = "Mật khẩu người dùng", example = "123456Aa@")
    private String password;

    @Schema(description = "Địa chỉ người dùng", example = "BG")
    private String address;

    @Schema(description = "Giới tính người dùng", example = "MALE - FEMALE")
    @Pattern(regexp = AppConstants.Gender.REGEX_GENDER, message = GENDER_INVALID)
    private String gender;

    @Size(max = 20, message = "Role" + SIZE_MAX)
    @Pattern(regexp = AppConstants.Role.REGEX_ROLE, message = ROLE_INVALID)
    @Schema(description = "Chức vụ người dùng dùng", example = "MALE - FEMALE")
    private String role;

    @Schema(description = "Trạng thái người dùng dùng", example = "MALE - FEMALE")
    private String status;
}
