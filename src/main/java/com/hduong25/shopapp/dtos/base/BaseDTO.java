package com.hduong25.shopapp.dtos.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hduong25.shopapp.utils.constants.AppConstants;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author: hduong25
 */

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDTO {
    private String id;
    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = AppConstants.DATE_TIME_FORMAT)
    @DateTimeFormat(pattern = AppConstants.DATE_TIME_FORMAT)
    private LocalDateTime createdDate;

    private String updatedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = AppConstants.DATE_TIME_FORMAT)
    @DateTimeFormat(pattern = AppConstants.DATE_TIME_FORMAT)
    private LocalDateTime updatedDate;
    
    private boolean isDeleted;
}
