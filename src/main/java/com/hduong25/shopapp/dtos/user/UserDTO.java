package com.hduong25.shopapp.dtos.user;

import com.hduong25.shopapp.dtos.base.BaseDTO;
import com.hduong25.shopapp.utils.constants.AppConstants;
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
public class UserDTO extends BaseDTO {
    private String name;

    @Email(message = EMAIL_INVALID)
    @Size(max = 100, message = "Email" + SIZE_MAX)
    private String email;

    private String phone;
    private String password;
    private String address;

    @Pattern(regexp = AppConstants.Gender.REGEX_GENDER, message = GENDER_INVALID)
    private String gender;

    @Size(max = 20, message = "Role" + SIZE_MAX)
    @Pattern(regexp = AppConstants.Role.REGEX_ROLE, message = ROLE_INVALID)
    private String role;

    private String status;
}
