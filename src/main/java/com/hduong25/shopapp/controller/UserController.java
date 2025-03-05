package com.hduong25.shopapp.controller;

import com.hduong25.shopapp.dtos.user.DetailsUserDTO;
import com.hduong25.shopapp.dtos.user.SearchUserDTO;
import com.hduong25.shopapp.dtos.user.UserDTO;
import com.hduong25.shopapp.service.UserService;
import com.hduong25.shopapp.utils.response.PageResponse;
import com.hduong25.shopapp.utils.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hduong25
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Users", description = "Search user API", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search success", content = @Content(schema = @Schema(implementation = UserDTO.class)))
    })
    @GetMapping("/search")
    public ResponseData<PageResponse<UserDTO>> search(@Valid @ParameterObject SearchUserDTO req) {
        return this.userService.search(req);
    }

    @Operation(summary = "Users", description = "Details user API", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Details success", content = @Content(schema = @Schema(implementation = UserDTO.class)))
    })
    @GetMapping("/details")
    public ResponseData<UserDTO> details(@RequestParam(value = "id", required = false) String id) {
        return this.userService.details(id);
    }

    @Operation(summary = "Users", description = "Save user API", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save user success", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @PostMapping("/save")
    public ResponseData<String> save(@Valid @RequestBody UserDTO req) {
        return this.userService.save(req);
    }

    @Operation(summary = "Users", description = "Delete user API", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save user success", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @PostMapping("/deleted")
    public ResponseData<String> deleted(@Valid @RequestBody DetailsUserDTO req) {
        return this.userService.deleted(req);
    }
}
