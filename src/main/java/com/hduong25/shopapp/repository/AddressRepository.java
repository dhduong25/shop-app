package com.hduong25.shopapp.repository;

import com.hduong25.shopapp.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: hduong25
 */

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, String> {
}
