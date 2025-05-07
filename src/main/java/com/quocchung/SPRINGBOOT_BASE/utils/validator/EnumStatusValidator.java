package com.quocchung.SPRINGBOOT_BASE.utils.validator;

import com.quocchung.SPRINGBOOT_BASE.utils.anotation.EnumStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EnumStatusValidator implements ConstraintValidator<EnumStatus, Enum<?>> {
  private Set<String> acceptedValues;

  @Override
  public void initialize(EnumStatus annotation) {
    acceptedValues = Arrays.stream(annotation.enumClass().getEnumConstants())
        .map(Enum::name)
        .collect(Collectors.toSet());
  }

  @Override
  public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
    return value == null || acceptedValues.contains(value.name());
  }
}
