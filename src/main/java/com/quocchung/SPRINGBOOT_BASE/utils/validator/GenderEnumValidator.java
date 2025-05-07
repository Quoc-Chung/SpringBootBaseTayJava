package com.quocchung.SPRINGBOOT_BASE.utils.validator;

import com.quocchung.SPRINGBOOT_BASE.utils.anotation.GenderEnum;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class GenderEnumValidator implements ConstraintValidator<GenderEnum, Enum<?>> {

  private Gender[] allowedGenders;

  @Override
  public void initialize(GenderEnum constraintAnnotation) {
    this.allowedGenders = constraintAnnotation.arrayEnum();
  }

  @Override
  public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
    if (value == null) return false;
    return Arrays.asList(allowedGenders).contains(value);
  }
}

