package com.hduong25.shopapp.entities;

import com.hduong25.shopapp.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "PRODUCT_DETAILS")
public class ProductDetailsEntity extends BaseEntity {
    @Column(name = "PRODUCT_ID", columnDefinition = "VARCHAR(50) NOT NULL")
    private String productId;

    @Column(name = "COLOR_ID", columnDefinition = "VARCHAR(50) NOT NULL")
    private String colorId;

    @Column(name = "SIZE_ID", columnDefinition = "VARCHAR(50) NOT NULL")
    private String sizeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COLOR_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private CategoryEntity color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SIZE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private CategoryEntity size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private ProductEntity product;
}
