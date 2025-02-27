package com.hduong25.shopapp.repository;

import com.hduong25.shopapp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: hduong25
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
