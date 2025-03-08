package com.hduong25.shopapp.service.impl;

import com.hduong25.shopapp.dtos.address.AddressDTO;
import com.hduong25.shopapp.dtos.address.DetailsAddressDTO;
import com.hduong25.shopapp.mapper.AddressMapper;
import com.hduong25.shopapp.repository.AddressRepository;
import com.hduong25.shopapp.service.AddressService;
import com.hduong25.shopapp.utils.response.PageResponse;
import com.hduong25.shopapp.utils.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: hduong25
 */

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public ResponseData<String> save(AddressDTO req) {
        return null;
    }

    @Override
    public ResponseData<PageResponse<AddressDTO>> search(AddressDTO req) {
        return null;
    }

    @Override
    public ResponseData<AddressDTO> details(DetailsAddressDTO req) {
        return null;
    }

    @Override
    public ResponseData<String> deleted(DetailsAddressDTO req) {
        return null;
    }

    private void checkDuplicate(AddressDTO req) {
        
    }
}
