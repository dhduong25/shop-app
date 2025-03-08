package com.hduong25.shopapp.mapper;

import com.hduong25.shopapp.dtos.address.AddressDTO;
import com.hduong25.shopapp.entities.AddressEntity;
import com.hduong25.shopapp.utils.MapperUtils;
import com.hduong25.shopapp.utils.ModelMapperUtils;
import org.springframework.stereotype.Component;

/**
 * @author: hduong25
 */

@Component
public class AddressMapper implements MapperUtils<AddressEntity, AddressDTO> {
    @Override
    public AddressEntity toEntity(AddressDTO dto) {
        return ModelMapperUtils.map(dto, AddressEntity.class);
    }

    @Override
    public AddressDTO toDto(AddressEntity entity) {
        return ModelMapperUtils.map(entity, AddressDTO.class);
    }

    @Override
    public AddressEntity mapOnUpdate(AddressEntity entity, AddressDTO dto) {
        entity.setName(dto.getName());
        entity.setParentCode(dto.getParentCode());
        entity.setCode(dto.getCode());
        
        return entity;
    }
}
