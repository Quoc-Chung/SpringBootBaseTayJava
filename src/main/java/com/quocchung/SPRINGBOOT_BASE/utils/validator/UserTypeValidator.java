package com.quocchung.SPRINGBOOT_BASE.utils.validator;

import com.quocchung.SPRINGBOOT_BASE.utils.anotation.UserTypeAnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Stream;

public class UserTypeValidator implements ConstraintValidator<UserTypeAnotation, CharSequence> {

  private List acceptedValues;

  @Override
  public void initialize(UserTypeAnotation enumValue) {
    acceptedValues = Stream.of(enumValue.enumClass().getEnumConstants())
        .map(Enum::name)
        .toList();
  }

  @Override
  public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }

    return acceptedValues.contains(value.toString().toUpperCase());
  }
}
