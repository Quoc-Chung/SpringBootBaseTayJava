package com.quocchung.SPRINGBOOT_BASE.utils.anotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import com.quocchung.SPRINGBOOT_BASE.utils.validator.PermissionEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD,METHOD,PARAMETER})
@Constraint(validatedBy = {PermissionEnumValidator.class})
public @interface PermissionEnum {
  String name();
  String regex();
  String message() default "{name} must matcher regular expression {regex}";

  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};


}
