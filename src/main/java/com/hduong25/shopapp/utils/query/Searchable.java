package com.hduong25.shopapp.utils.query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.Data;

/**
 * @author: hduong25
 */

@Data
@Valid
@Schema(description = "Searchable")
public abstract class Searchable {
    private Page page;
    private Order order;

    @Data
    public static class Page {
        @Min(1)
        @Schema(description = "Page size", defaultValue = "1")
        private int pageSize;

        @Min(1)
        @Schema(description = "Page number", defaultValue = "1")
        private int pageNum;
    }

    @Data
    public static class Order {
        @Schema(description = "Field order")
        private String field;

        @Schema(description = "Direction order [DESC/ASC]")
        private String direction;
    }
}
