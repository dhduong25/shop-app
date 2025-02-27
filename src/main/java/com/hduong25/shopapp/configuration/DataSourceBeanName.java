package com.hduong25.shopapp.configuration;

import lombok.experimental.UtilityClass;

/**
 * @author: hduong25
 */

@UtilityClass
public class DataSourceBeanName {
    public static final String DATASOURCE_PREFIX = "spring.datasource";

    /// Tiền tố để đọc cấu hình cho DataSource từ file cấu hình.
    public static final String DATASOURCE_PROPERTIES_PREFIX = DATASOURCE_PREFIX + ".shop-app-mysql";

    /// Tiền tố để đọc cấu hình cho HikariCP (connection pool).
    public static final String DATASOURCE_PROPERTIES_HIKARI_PREFIX = DATASOURCE_PREFIX + ".hikari";

    /// Tên bean DataSourceProperties.
    public static final String DATASOURCE_PROPERTIES_NAME = "primaryProperties";

    /// Tên bean DataSource.
    public static final String DATASOURCE_NAME = "primaryDataSource";

    /// Tên bean EntityManagerFactory.
    public static final String ENTITY_MANAGER_FACTORY_NAME = "primaryEntityManagerFactory";

    /// Tên bean TransactionManager.
    public static final String TRANSACTION_MANAGER_NAME = "primaryTransactionManager";

    /// Tiền tố cấu hình cho JPA trong file cấu hình.
    public static final String JPA_PREFIX = "spring.jpa";

    /// Các package chứa các entity JPA.
    static final String[] ENTITY_PACKAGE = {"com.hduong25.shopapp"};
}
