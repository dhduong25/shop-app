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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class UserEntity extends BaseEntity {
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;

    @Column(name = "ROLE", nullable = false, length = 20)
    private String role;

    @Column(name = "GENDER", length = 20)
    private String gender;

    @Column(name = "PHONE", length = 100)
    private String phone;

    @Column(name = "CITY_ID", columnDefinition = "VARCHAR(50)")
    private String cityId;

    @Column(name = "DISTRICT_ID", columnDefinition = "VARCHAR(50)")
    private String districtId;

    @Column(name = "WARD_ID", columnDefinition = "VARCHAR(50)")
    private String wardId;

    @Column(name = "ADDRESS_DETAILS", columnDefinition = "VARCHAR(100) NOT NULL", length = 100)
    private String addressDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID", insertable = false, updatable = false)
    private AddressEntity city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISTRICT_ID", insertable = false, updatable = false)
    private AddressEntity district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WARD_ID", insertable = false, updatable = false)
    private AddressEntity ward;
}
