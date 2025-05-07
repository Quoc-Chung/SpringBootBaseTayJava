package com.quocchung.SPRINGBOOT_BASE.utils.anotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.quocchung.SPRINGBOOT_BASE.utils.enums.Gender;
import com.quocchung.SPRINGBOOT_BASE.utils.validator.GenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/*

  @GenderAnotation(anyOf = {MALE, FEMALE, OTHER})
  private Gender gender;

*/

@Documented
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = GenderValidator.class)
public @interface GenderAnotation {
  /*- chứa các cái thằng bên trong  -*/
  Gender[] anyOf();

  String message() default "must be any of {anyOf}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
