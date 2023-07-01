package com.custom.validation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * This class must be annotated with @Embeddable
 * We will write only the primary key columns here
 * There must not be any primary key column in the parent table
 * The parent table will use this as a property there.
 * The property must be annotated with @EmbeddedId
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CustomerOrderPrimaryData {

    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Column(name = "ORDER_NAME")
    private String orderName;

    @Override
    public String toString() {
        return "CustomerOrderPrimaryData{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrderPrimaryData that = (CustomerOrderPrimaryData) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(orderName, that.orderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderName);
    }
}
