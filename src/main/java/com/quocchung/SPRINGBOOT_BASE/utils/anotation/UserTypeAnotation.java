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
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserTypeValidator.class)
public @interface UserTypeAnotation {
  String name();
  Class<? extends Enum<?>> enumClass();



  String message() default "{name} must be any of enum {enumClass}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
