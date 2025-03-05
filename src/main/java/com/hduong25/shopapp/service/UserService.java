package com.hduong25.shopapp.service;

import com.hduong25.shopapp.dtos.user.DetailsUserDTO;
import com.hduong25.shopapp.dtos.user.SearchUserDTO;
import com.hduong25.shopapp.dtos.user.UserDTO;
import com.hduong25.shopapp.utils.response.PageResponse;
import com.hduong25.shopapp.utils.response.ResponseData;

/**
 * @author: hduong25
 */

public interface UserService {
    ResponseData<PageResponse<UserDTO>> search(SearchUserDTO req);

    ResponseData<String> save(UserDTO req);

    ResponseData<UserDTO> details(String id);

    ResponseData<String> deleted(DetailsUserDTO req);
}
