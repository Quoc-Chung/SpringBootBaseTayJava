package com.quocchung.SPRINGBOOT_BASE.utils.validator;

import com.quocchung.SPRINGBOOT_BASE.utils.anotation.UserTypeAnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class UserTypeValidator implements ConstraintValidator<UserTypeAnotation, Enum<?>> {

  private List<String> acceptedValues;

  @Override
  public void initialize(UserTypeAnotation annotation) {
    acceptedValues = Arrays.stream(annotation.enumClass().getEnumConstants())
        .map(Enum::name)
        .toList();
  }

  @Override
  public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }
    return acceptedValues.contains(value.name());
  }
}

