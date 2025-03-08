package com.hduong25.shopapp.service;

import com.hduong25.shopapp.utils.response.PageResponse;
import com.hduong25.shopapp.utils.response.ResponseData;

/**
 * @author: hduong25
 */

public interface BaseService<R, F, D> {
    ResponseData<String> save(R req);

    ResponseData<PageResponse<R>> search(F req);

    ResponseData<R> details(D req);

    ResponseData<String> deleted(D req);
}
