package com.custom.validation.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateQueryNativeQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> getAllRecords(String tableName) {
        Query query = entityManager.createNativeQuery("SELECT * FROM " + tableName);
        return query.getResultList();
    }
}
