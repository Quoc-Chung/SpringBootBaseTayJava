package com.quocchung.SPRINGBOOT_BASE.utils.anotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import com.quocchung.SPRINGBOOT_BASE.utils.enums.Gender;
import com.quocchung.SPRINGBOOT_BASE.utils.validator.GenderEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = GenderEnumValidator.class)
public @interface GenderEnum {
  Gender[] arrayEnum();
  String message() default "gender must be any {arrayEnum} .";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}

