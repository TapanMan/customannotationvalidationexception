package com.custom.validation.repository;

import com.custom.validation.entity.CustomerBatch;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This Entity and it's component are for Spring Batch only
 */

public interface CustomerBatchRepository extends JpaRepository<CustomerBatch, Integer> {
}
