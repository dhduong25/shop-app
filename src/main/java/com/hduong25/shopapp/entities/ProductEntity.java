package com.hduong25.shopapp.entities;

import com.hduong25.shopapp.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author: hduong25
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT")
public class ProductEntity extends BaseEntity {
    @Column(name = "NAME", columnDefinition = "VARCHAR(500) NOT NULL")
    private String name;

    @Column(name = "DESCR", columnDefinition = "LONGTEXT")
    private String descr;

    @Column(name = "PRICE", columnDefinition = "DECIMAL(19,4) NOT NULL")
    private BigDecimal price;
}
