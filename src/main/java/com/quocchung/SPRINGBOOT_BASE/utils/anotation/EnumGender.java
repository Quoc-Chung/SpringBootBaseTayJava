package com.quocchung.SPRINGBOOT_BASE.utils.anotation;

import com.quocchung.SPRINGBOOT_BASE.utils.validator.EnumGenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {EnumGenderValidator.class})
public @interface EnumGender {
  String message() default "Gender must be any of enum values";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
  Class<? extends Enum<?>> enumClass();

}
