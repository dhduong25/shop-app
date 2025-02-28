package com.hduong25.shopapp.service.impl;

import com.hduong25.shopapp.dtos.user.DetailsUserDTO;
import com.hduong25.shopapp.dtos.user.SearchUserDTO;
import com.hduong25.shopapp.dtos.user.UserDTO;
import com.hduong25.shopapp.entities.UserEntity;
import com.hduong25.shopapp.mapper.UserMapper;
import com.hduong25.shopapp.repository.UserRepository;
import com.hduong25.shopapp.resutmessage.user.UserResponseMessages;
import com.hduong25.shopapp.service.UserService;
import com.hduong25.shopapp.utils.MessageUtils;
import com.hduong25.shopapp.utils.exception.ApiException;
import com.hduong25.shopapp.utils.exception.ResponseException;
import com.hduong25.shopapp.utils.query.QueryUtils;
import com.hduong25.shopapp.utils.response.PageResponse;
import com.hduong25.shopapp.utils.response.ResponseData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author: hduong25
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MessageUtils messageUtils;

    @Override
    public ResponseData.Success<PageResponse<UserDTO>> search(SearchUserDTO req) {
        log.info("START - Search user with req: {}", req);
        try {
            Pageable pageable = QueryUtils.createPageRequest(req, Sort.Order.desc("id"));
            Page<UserEntity> entityPage = this.userRepository.findAll(pageable);

            log.info("SUCCESS - Search user success with req: {}", req);
            String message = this.messageUtils.getMessage(UserResponseMessages.Created.CREATED_USER_SUCCESS);
            return ResponseData.ok(
                    message,
                    new PageResponse<>(entityPage.map(this.userMapper::toDto))
            );
        } catch (Exception e) {
            log.error("ERROR - Search user error with req: {} and Error Message: {}", req, e.getMessage());
            throw new ApiException("Exception", HttpStatus.BAD_REQUEST, "Search user", "Search");
        }
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
