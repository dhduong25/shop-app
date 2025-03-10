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
@Table(name = "PRODUCT_ATTRIBUTE")
public class ProductAttributeEntity extends BaseEntity {
    @Column(name = "CODE", columnDefinition = "VARCHAR(50)", nullable = false)
    private String code;

    @Column(name = "NAME", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "PRODUCT_ID", columnDefinition = "VARCHAR(50)", nullable = false)
    private String productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private ProductEntity product;
}
