package com.custom.validation.customannotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class GenderValidator implements ConstraintValidator<GenderCheck, String> {

    @Override
    public boolean isValid(String genderType, ConstraintValidatorContext constraintValidatorContext) {
       List<String> genderList = Arrays.asList("Male","Female");
       return genderList.contains(genderType);
    }
}
