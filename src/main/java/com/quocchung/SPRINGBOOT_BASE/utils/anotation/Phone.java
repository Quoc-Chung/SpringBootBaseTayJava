package com.quocchung.SPRINGBOOT_BASE.utils.anotation;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.quocchung.SPRINGBOOT_BASE.utils.validator.PhoneValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ FIELD, PARAMETER,METHOD })
@Retention(RUNTIME)
public @interface Phone {
  String message() default "Số điện thoại không hợp lệ";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
