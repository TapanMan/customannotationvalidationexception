package com.custom.validation.repository;

import com.custom.validation.entity.CustomerOrder;
import com.custom.validation.entity.CustomerOrderPrimaryData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This repository contains the entity name along with embeddable property type
 */
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, CustomerOrderPrimaryData> {
}
