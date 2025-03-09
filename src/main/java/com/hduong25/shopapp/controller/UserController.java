package com.hduong25.shopapp.controller;

import com.hduong25.shopapp.dtos.user.DetailsUserDTO;
import com.hduong25.shopapp.dtos.user.SearchUserDTO;
import com.hduong25.shopapp.dtos.user.UserDTO;
import com.hduong25.shopapp.service.UserService;
import com.hduong25.shopapp.utils.response.PageResponse;
import com.hduong25.shopapp.utils.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hduong25
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Tag(name = "User", description = "Danh sách API quản lý người dùng")
public class UserController implements BaseController<UserDTO, SearchUserDTO, DetailsUserDTO> {

    private final UserService userService;

    @Override
    @Operation(summary = "Save user", description = "API Lưu thông tin người dùng")
    public ResponseData<String> save(UserDTO req) {
        return this.userService.save(req);
    }

    @Override
    @Operation(summary = "Search user", description = "API Tìm kiếm người dùng")
    public ResponseData<PageResponse<UserDTO>> search(SearchUserDTO req) {
        return this.userService.search(req);
    }

    @Override
    @Operation(summary = "Details user", description = "API Chi tiết người dùng")
    public ResponseData<UserDTO> details(DetailsUserDTO req) {
        return this.userService.details(req);
    }

    @Override
    @Operation(summary = "Deleted User", description = "API Xoá người dùng")
    public ResponseData<String> deleted(DetailsUserDTO req) {
        return this.userService.deleted(req);
    }
}
