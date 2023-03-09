package com.custom.validation.customannotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = GenderValidator.class)

public @interface GenderCheck {
    public String message () default "Gender Type must be Male or Female";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
