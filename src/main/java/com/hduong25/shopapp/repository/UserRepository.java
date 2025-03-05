package com.hduong25.shopapp.repository;

import com.hduong25.shopapp.dtos.user.SearchUserDTO;
import com.hduong25.shopapp.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: hduong25
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmailOrPhone(String email, String phone);

    @Query(value = """
            select u from UserEntity u
            where (:#{#req.name} is null or u.name like '%' || :#{#req.name} || '%')
              and (:#{#req.phone} is null or u.phone like '%' || :#{#req.phone} || '%')
              and (:#{#req.email} is null or u.email like '%' || :#{#req.email} || '%')
              and (:#{#req.address} is null or u.address like '%' || :#{#req.address} || '%')
              and (:#{#req.gender} is null or u.gender = :#{#req.gender})
              and (:#{#req.role} is null or u.role = :#{#req.role})
              and (:#{#req.isDeleted} is not null and u.isDeleted = :#{#req.isDeleted} or u.isDeleted <> true)
              and (:#{#req.status} is not null and u.status = :#{#req.status} or u.status <> 'INACTIVE')
            """)
    Page<UserEntity> findWithFilter(@Param("req") SearchUserDTO req,
                                    Pageable pageable);
}
