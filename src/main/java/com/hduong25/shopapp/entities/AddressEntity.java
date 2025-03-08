package com.hduong25.shopapp.entities;

import com.hduong25.shopapp.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: hduong25
 */

@Getter
@Setter
@Entity
@Table(name = "ADDRESS")
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity extends BaseEntity {
    @Column(name = "CODE", unique = true, length = 50)
    private String code;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "PARENT_CODE", length = 30)
    private String parentCode;
}
