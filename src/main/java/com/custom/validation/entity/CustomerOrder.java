package com.custom.validation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * The aim of this table is to create a composite primary key in JPA
 * We must not keep any primary key column here
 * For primary key column, create a separate entity
 * And the separate entity doesn't need the table name @Table(name = "XXL_YYYY")
 * Also that does not need any @Entity there
 * The entity name will be here in the main table as one of the attribute
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_ORDER")
public class CustomerOrder {

    @EmbeddedId
    private CustomerOrderPrimaryData customerOrderPrimaryData;

    @Column(name = "PERSON_NAME")
    private String personName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "POSTAL_CODE")
    private Integer postalCode;

    @Column(name = "COUNTRY")
    private String country;

    @CreationTimestamp
    @Column(name = "ORDER_DATE")
    private LocalDateTime orderDate;

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "customerOrderPrimaryData=" + customerOrderPrimaryData +
                ", personName='" + personName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder that = (CustomerOrder) o;
        return Objects.equals(customerOrderPrimaryData, that.customerOrderPrimaryData) && Objects.equals(personName, that.personName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(postalCode, that.postalCode) && Objects.equals(country, that.country) && Objects.equals(orderDate, that.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerOrderPrimaryData, personName, address, city, postalCode, country, orderDate);
    }
}
