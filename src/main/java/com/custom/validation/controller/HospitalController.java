package com.custom.validation.controller;

import com.custom.validation.entity.Hospital;
import com.custom.validation.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalController {
    @Autowired
    public HospitalService hospitalService;
    @GetMapping("/all-hospitals")
    public List<Hospital> getAllHospitals(){
        return hospitalService.getAllHospitals();
    }
}
