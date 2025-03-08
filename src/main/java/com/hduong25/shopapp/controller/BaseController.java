package com.hduong25.shopapp.controller;

import com.hduong25.shopapp.utils.response.PageResponse;
import com.hduong25.shopapp.utils.response.ResponseData;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: hduong25
 */

public interface BaseController<R, F, D> {
    @PostMapping(value = "/save", name = "API Save or Update data")
    ResponseData<String> save(@Parameter(in = ParameterIn.DEFAULT, description = "Request body", schema = @Schema())
                              @Valid @RequestBody R req);

    @GetMapping(value = "/search", name = "API Search")
    ResponseData<PageResponse<R>> search(@Parameter(in = ParameterIn.QUERY, description = "Request body", schema = @Schema())
                                         @ParameterObject F req);

    @GetMapping(value = "/details", name = "API Details")
    ResponseData<R> details(@Parameter(in = ParameterIn.QUERY, description = "Request body", schema = @Schema())
                            @Valid @ParameterObject D req);

    @GetMapping(value = "/deleted", name = "API Deleted data")
    ResponseData<String> deleted(@Parameter(in = ParameterIn.QUERY, description = "Request body", schema = @Schema())
                                 @Valid @RequestBody D req);
}
