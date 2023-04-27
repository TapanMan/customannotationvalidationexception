package com.custom.validation.repository;

import com.custom.validation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * This repository and it's component are for Customers only
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // This is SQL [select * from customers where customer_name =], The table name and column name must match
    @Query(value = "select * from customers where customer_name =:custName", nativeQuery = true)
    Customer getCustomerByCustomerName(String custName);

    @Query(value = "select * from customers where customer_name =:custName and address =:addr", nativeQuery = true)
    Customer getCustomerByNameAndAddress(String custName, String addr);

    // For JPQL, there must not be any value tag and nativeQuery = true tag, Entity Name and the Property must match
    // :XXX must be matched inside the @Param value here, No space after the colon [between : and contName]
    // This must be matched [select c from Customer c where c.contactName =]
    // GET: http://localhost:8080/customer-name-city?customer-name=Renuka Mandal&city=Bangalore
    // The above is working fine
    @Query("select c from Customer c where c.contactName =:contName and c.city =:ct")
    List<Customer> getCustomerByContactNameAndCity(@Param("contName") String contactName, @Param("ct") String city);
    // Declare the variable in a proper way, this is not a valid [cust-Name] String property, and the application will fail

    // No need to write @Entity(name="XXX") something in the Entity or POJO
    @Query("select c from Customer c")
    public List<Customer> getAllCustomer();

}