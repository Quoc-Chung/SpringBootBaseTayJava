package com.quocchung.SPRINGBOOT_BASE.utils.anotation;


import static java.lang.annotation.ElementType.*;

import com.quocchung.SPRINGBOOT_BASE.utils.validator.UserTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/*
      @UserTypeAnotation(name = "type", enumClass = UserType.class)
       private String type;


*/
@Target({ElementType.FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserTypeValidator.class)
public @interface UserTypeAnotation {
  String name();
  Class<? extends Enum<?>> enumClass();

  String message() default "{name} must be a valid enum of {enumClass}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}

