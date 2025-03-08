package com.hduong25.shopapp.service.impl;

import com.hduong25.shopapp.dtos.user.DetailsUserDTO;
import com.hduong25.shopapp.dtos.user.SearchUserDTO;
import com.hduong25.shopapp.dtos.user.UserDTO;
import com.hduong25.shopapp.entities.UserEntity;
import com.hduong25.shopapp.mapper.UserMapper;
import com.hduong25.shopapp.repository.UserRepository;
import com.hduong25.shopapp.service.CommonService;
import com.hduong25.shopapp.service.UserService;
import com.hduong25.shopapp.utils.MessageUtils;
import com.hduong25.shopapp.utils.exception.ApiException;
import com.hduong25.shopapp.utils.exception.ResponseException;
import com.hduong25.shopapp.utils.query.QueryUtils;
import com.hduong25.shopapp.utils.response.PageResponse;
import com.hduong25.shopapp.utils.response.ResponseData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.hduong25.shopapp.responsemessage.user.UserResponseMessages.*;

/**
 * @author: hduong25
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CommonService<UserEntity, String> implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MessageUtils messageUtils;

    @Override
    @Transactional(readOnly = true)
    public ResponseData<PageResponse<UserDTO>> search(SearchUserDTO req) {
        log.info("START - Search user with req: {}", req);
        try {
            Pageable pageable = QueryUtils.createPageRequest(req, Sort.Order.desc("id"));
            Page<UserEntity> entityPage = this.userRepository.findWithFilter(req, pageable);

            log.info("SUCCESS - Search user success with req: {}", req);
            String message = this.messageUtils.getMessage(SEARCH_USER_SUCCESS);
            return ResponseData.ok(
                    message,
                    new PageResponse<>(entityPage.map(this.userMapper::toDto))
            );
        } catch (Exception e) {
            log.error("ERROR - Search user error with req: {} and Error Message: {}", req, e.getMessage());
            String errorMessage = this.messageUtils.getMessage(Created.CREATED_USER_ERROR);
            throw new ApiException(errorMessage, HttpStatus.BAD_REQUEST, "Search user", "Search");
        }
    }

    @Override
    @Transactional
    public ResponseData<String> save(UserDTO req) {
        log.info("START - Save user with req: {}", req);
        this.checkDuplicate(req);
        String id = StringUtils.isEmpty(req.getId())
                ? this.create(req)
                : this.update(req);

        log.info("SUCCESS - Save user with req: {}, Successfully", req);
        return ResponseData.ok(
                this.messageUtils.getMessage(Created.CREATED_USER_SUCCESS),
                id
        );
    }

    @Override
    public ResponseData<UserDTO> details(DetailsUserDTO req) {
        log.info("START - Get details user");
        String idSearch = StringUtils.isEmpty(req.getId())
                ? "123" // Lấy thông tin user từ token
                : req.getId();
        UserEntity user = this.findEntityWithId(this.userRepository, idSearch, "User");
        UserDTO dto = this.userMapper.toDto(user);

        log.info("SUCCESS - Get details user with ID: {}", idSearch);
        return ResponseData.ok(dto);
    }

    @Override
    public ResponseData<String> deleted(DetailsUserDTO req) {
        UserEntity user = this.findEntityWithId(this.userRepository, req.getId(), "User");
        user.setDeleted(true);
        this.userRepository.save(user);

        return ResponseData.ok(this.messageUtils.getMessage("user.deleted.success"));
    }

    private String create(UserDTO req) {
        UserEntity user = this.userMapper.toEntity(req);
        user.setPassword(this.encodePassword(req.getPassword()));
        this.userRepository.save(user);

        return user.getId();
    }

    private String update(UserDTO req) {
        UserEntity user = this.findEntityWithId(this.userRepository, req.getId(), "User");
        user = this.userMapper.mapOnUpdate(user, req);
        this.userRepository.save(user);

        return user.getId();
    }

    private void checkDuplicate(UserDTO req) {
        this.userRepository.findByEmailOrPhone(req.getEmail(), req.getPhone())
                .ifPresent(e -> {
                    if (!e.getId().equals(req.getId()))
                        throw new ResponseException(this.messageUtils.getMessage(USER_DUPLICATE_EMAIL_OR_PHONE));
                });
    }

    private String encodePassword(String password) {
        return this.passwordEncoder.encode(password);
    }
}
