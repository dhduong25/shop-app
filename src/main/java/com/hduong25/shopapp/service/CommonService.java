package com.hduong25.shopapp.service;

import com.hduong25.shopapp.utils.exception.ResponseException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author: hduong25
 */

public abstract class CommonService<T, I> {

    public T findEntityWithId(JpaRepository<T, I> repository, I id, String eName) {
        return Optional.ofNullable(id)
                .flatMap(repository::findById)
                .orElseThrow(() -> new ResponseException(String.format("This [%s] with id [%s] not found", eName, id)));
    }

}
