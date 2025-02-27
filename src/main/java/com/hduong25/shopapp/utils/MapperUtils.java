package com.hduong25.shopapp.utils;

/**
 * @author: hduong25
 */

public interface MapperUtils<E, D> {
    E toEntity(D dto);

    D toDto(E entity);
}
