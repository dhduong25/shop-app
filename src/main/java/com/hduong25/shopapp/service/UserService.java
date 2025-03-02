package com.hduong25.shopapp.service;

import com.hduong25.shopapp.dtos.user.SearchUserDTO;
import com.hduong25.shopapp.dtos.user.UserDTO;
import com.hduong25.shopapp.utils.response.PageResponse;
import com.hduong25.shopapp.utils.response.ResponseData;

/**
 * @author: hduong25
 */

public interface UserService {
    ResponseData.Success<PageResponse<UserDTO>> search(SearchUserDTO req);

    ResponseData.Success<String> save(UserDTO req);

    ResponseData.Success<UserDTO> details(String id);
}
