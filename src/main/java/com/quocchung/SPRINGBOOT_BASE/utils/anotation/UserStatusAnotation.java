package com.quocchung.SPRINGBOOT_BASE.utils.anotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.quocchung.SPRINGBOOT_BASE.utils.validator.UserStatusValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/*
    @UserStatusAnotation(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
    private UserStatus status;

*/
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = UserStatusValidator.class)
public @interface UserStatusAnotation {
  String name();
  String regexp();

  String message() default "{name} must match {regexp}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};


}