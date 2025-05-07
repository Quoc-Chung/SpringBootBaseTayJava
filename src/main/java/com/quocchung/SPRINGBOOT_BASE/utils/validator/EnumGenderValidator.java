package com.quocchung.SPRINGBOOT_BASE.utils.validator;

import com.quocchung.SPRINGBOOT_BASE.utils.anotation.EnumGender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EnumGenderValidator  implements ConstraintValidator<EnumGender, Enum<?>> {

  private Set<String> lstGender;
  @Override
  public void initialize(EnumGender enumGender) {
    lstGender = Arrays.stream(enumGender.enumClass().getEnumConstants())
        .map(Enum::name)
        .collect(Collectors.toSet());
  }

  @Override
  public boolean isValid(Enum<?> anEnum, ConstraintValidatorContext constraintValidatorContext) {
   return anEnum!=null && lstGender.contains(anEnum.name());
  }
}
