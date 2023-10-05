package com.custom.validation.controller;

import com.custom.validation.entity.User;
import com.custom.validation.service.CreateQueryNativeQueryService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreateQueryNativeQueryController {

    @Autowired
    private CreateQueryNativeQueryService createQueryNativeQueryService;

    @PersistenceContext
    private EntityManager entityManager;
    // Here there is no need of any Interface which extends JpaRepository
    // Also there is no need of the Entity if we are using native query
    // Entity is required when we deal with the createQuery
    @GetMapping("/create-query")
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("SELECT user from User user");
        return query.getResultList();
    }

    // Native Query, so no Entity is involved
    @GetMapping("/create-native-query")
    public List<Object[]> getAllUsersNative() {
        Query query = entityManager.createNativeQuery("SELECT * FROM USER_TBL");
        return query.getResultList();
    }

    // Pass the table dynamically and get the value
    // Here we need a service class to call the method
    //GET: http://localhost:8080/create-native-query/USER_TBL
    // USER_TBL  is my table name, and getting exact result

    @GetMapping("/create-native-query/{tableName}")
    public List<Object[]> getAllUsersNativeDynamically(@PathVariable String tableName) {
        return createQueryNativeQueryService.getAllRecords(tableName);
    }
}