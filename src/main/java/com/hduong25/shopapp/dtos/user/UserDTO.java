package com.hduong25.shopapp.dtos.user;

import com.hduong25.shopapp.dtos.base.BaseDTO;
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
public class UserDTO extends BaseDTO {
    private String name;
    private String email;
    private String password;
    private String address;
    private String role;
}
