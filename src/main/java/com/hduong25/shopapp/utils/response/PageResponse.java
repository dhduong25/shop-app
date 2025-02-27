package com.hduong25.shopapp.utils.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: hduong25
 */

@Getter
@Setter
@NoArgsConstructor
public class PageResponse<T> {
    private int page;
    private int size;
    private List<T> content;
    private long total;

    public PageResponse(Page<T> page) {
        this.page = page.getPageable().getPageNumber() + 1;
        this.size = page.getPageable().getPageSize();
        this.content = page.getContent();
        this.total = page.getTotalElements();
    }
}
