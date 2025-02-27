package com.hduong25.shopapp.utils.query;

import com.hduong25.shopapp.utils.constants.AppConstants;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: hduong25
 */

@UtilityClass
public class QueryUtils {

    public static Pageable createPageRequest(Searchable req, Sort.Order... ordersDefault) {
        Searchable.Page page = req.getPage();
        List<Sort.Order> orders = createOrderFromRequest(req.getOrder(), ordersDefault);

        int pageNum = (page != null && page.getPageNum() >= 1) ? page.getPageNum() - 1 : 0;
        int pageSize = (page != null && page.getPageSize() > 0) ? Math.min(page.getPageSize(), 1000) : 10;

        return PageRequest.of(pageNum, pageSize, Sort.by(orders));
    }

    public static Pageable createPageRequest(int pageNum, int pageSize, Sort.Order... orders) {
        return PageRequest.of(Math.max(pageNum - 1, 0), Math.min(pageSize, 1000), Sort.by(orders));
    }

    public static Pageable createUnPage(Searchable req, Sort.Order... ordersDefault) {
        List<Sort.Order> orders = createOrderFromRequest(req.getOrder(), ordersDefault);
        return Pageable.unpaged(Sort.by(orders));
    }

    public static Pageable createUnPage(Sort.Order... ordersDefault) {
        return Pageable.unpaged(Sort.by(ordersDefault));
    }

    private static List<Sort.Order> createOrderFromRequest(Searchable.Order order, Sort.Order... ordersDefault) {
        List<Sort.Order> orders = new ArrayList<>();

        if (order != null && !StringUtils.isEmpty(order.getField()) && !StringUtils.isEmpty(order.getDirection())) {
            Sort.Direction direction = AppConstants.Order.DESC.equalsIgnoreCase(order.getDirection())
                    ? Sort.Direction.DESC
                    : Sort.Direction.ASC;
            orders.add(new Sort.Order(direction, order.getField()));
        }

        if (ordersDefault != null && ordersDefault.length > 0) {
            orders.addAll(Arrays.asList(ordersDefault));
        }

        return orders;
    }
}
