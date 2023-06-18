package com.custom.validation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This Entity and it's component are for Spring Batch only
 */
@Entity
@Table(name = "CUSTOMER_BATCH")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBatch {
    @Id
    @Column(name = "CUSTOMER_BATCH_ID")
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;
    
}
