package com.luv2code.springboot.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // Define default course code
    public String value() default "LUV";

    // Define default error message
    public String message() default "Must start with LUV";

    // Define default group
    public Class<?>[] groups() default {};

    // Define default payload
    public Class<? extends Payload>[] payload() default{};
}
