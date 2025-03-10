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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CATEGORY")
public class CategoryEntity extends BaseEntity {
    @Column(name = "CODE", columnDefinition = "VARCHAR(30) NOT NULL")
    private String code;

    @Column(name = "TYPE", columnDefinition = "VARCHAR(20) NOT NULL")
    private String type;

    @Column(name = "NAME", columnDefinition = "VARCHAR(20) NOT NULL")
    private String name;
}
