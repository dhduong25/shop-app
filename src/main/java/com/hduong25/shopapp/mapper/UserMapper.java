package com.hduong25.shopapp.mapper;

import com.hduong25.shopapp.dtos.user.UserDTO;
import com.hduong25.shopapp.entities.UserEntity;
import com.hduong25.shopapp.utils.MapperUtils;
import com.hduong25.shopapp.utils.ModelMapperUtils;
import org.springframework.stereotype.Component;

/**
 * @author: hduong25
 */

@Component
public class UserMapper implements MapperUtils<UserEntity, UserDTO> {
    @Override
    public UserEntity toEntity(UserDTO dto) {
        return ModelMapperUtils.map(dto, UserEntity.class);
    }

    @Override
    public UserDTO toDto(UserEntity entity) {
        return ModelMapperUtils.map(entity, UserDTO.class);
    }
}
