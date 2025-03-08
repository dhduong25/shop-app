package com.hduong25.shopapp.dtos.base;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: hduong25
 */

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class DetailsBaseDTO {
    @Schema(description = "ID của bản ghi")
    @NotEmpty(message = "ID không có dữ liệu")
    private String id;
}
