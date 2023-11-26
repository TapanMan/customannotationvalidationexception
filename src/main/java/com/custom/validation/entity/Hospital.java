package com.custom.validation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    private int id;
    private String name;
    private String city;
    private double rating;
}
