package com.hduong25.shopapp.service.impl;

import com.hduong25.shopapp.dtos.user.DetailsUserDTO;
import com.hduong25.shopapp.dtos.user.SearchUserDTO;
import com.hduong25.shopapp.dtos.user.UserDTO;
import com.hduong25.shopapp.entities.UserEntity;
import com.hduong25.shopapp.mapper.UserMapper;
import com.hduong25.shopapp.repository.UserRepository;
import com.hduong25.shopapp.service.UserService;
import com.hduong25.shopapp.utils.MessageUtils;
import com.hduong25.shopapp.utils.query.QueryUtils;
import com.hduong25.shopapp.utils.response.PageResponse;
import com.hduong25.shopapp.utils.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author: hduong25
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MessageUtils messageUtils;

    @Override
    public ResponseData.Success<PageResponse<UserDTO>> search(SearchUserDTO req) {
        Pageable pageable = QueryUtils.createPageRequest(req, Sort.Order.desc("id"));
        Page<UserEntity> entityPage = this.userRepository.findAll(pageable);

        String message = this.messageUtils.getMessage("user.create.success");
        return ResponseData.ok(
                message,
                new PageResponse<>(entityPage.map(this.userMapper::toDto))
        );
    }

    @Override
    public ResponseData.Success<String> save(UserDTO req) {
        return null;
    }

    @Override
    public ResponseData.Success<String> details(DetailsUserDTO req) {
        return null;
    }
}
