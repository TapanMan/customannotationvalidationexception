package com.custom.validation.config;

import com.custom.validation.entity.CustomerBatch;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerBatchProcessor implements ItemProcessor<CustomerBatch, CustomerBatch> {
    @Override
    public CustomerBatch process(CustomerBatch customerBatch) throws Exception {
        return customerBatch;
    }
}
