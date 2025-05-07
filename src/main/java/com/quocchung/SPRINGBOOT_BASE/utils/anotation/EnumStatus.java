package com.quocchung.SPRINGBOOT_BASE.utils.anotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import com.quocchung.SPRINGBOOT_BASE.utils.validator.EnumStatusValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD,CONSTRUCTOR,PARAMETER,FIELD})
@Constraint(validatedBy = EnumStatusValidator.class)
public @interface EnumStatus {
  String message() default "Status must be any of enum values";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
  Class<? extends Enum<?>> enumClass();
}


