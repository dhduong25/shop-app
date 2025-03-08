package com.hduong25.shopapp.controller;

import com.hduong25.shopapp.dtos.address.AddressDTO;
import com.hduong25.shopapp.dtos.address.DetailsAddressDTO;
import com.hduong25.shopapp.service.AddressService;
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
@RequestMapping("/api/v1/address")
@Tag(name = "Address", description = "Danh sách API quản lý địa chỉ")
public class AddressController implements BaseController<AddressDTO, AddressDTO, DetailsAddressDTO> {

    private final AddressService addressService;

    @Override
    @Operation(summary = "Save address", description = "API Lưu thông tin địa chỉ")
    public ResponseData<String> save(AddressDTO req) {
        return this.addressService.save(req);
    }

    @Override
    @Operation(summary = "Search address", description = "API Tìm kiếm địa chỉ")
    public ResponseData<PageResponse<AddressDTO>> search(AddressDTO req) {
        return this.addressService.search(req);
    }

    @Override
    @Operation(summary = "Details address", description = "API Chi tiết địa chỉ")
    public ResponseData<AddressDTO> details(DetailsAddressDTO req) {
        return this.addressService.details(req);
    }

    @Override
    @Operation(summary = "Deleted address", description = "API Xoá địa chỉ")
    public ResponseData<String> deleted(DetailsAddressDTO req) {
        return this.addressService.deleted(req);
    }
}
