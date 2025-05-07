package com.quocchung.SPRINGBOOT_BASE.utils.validator;

import com.quocchung.SPRINGBOOT_BASE.utils.anotation.PermissionEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PermissionEnumValidator implements ConstraintValidator<PermissionEnum, Enum<?>> {
  private  String regex;

  @Override
  public void initialize(PermissionEnum anotationLucDung) {
    regex = anotationLucDung.regex();
  }

  @Override
  public boolean isValid(Enum<?> anEnum, ConstraintValidatorContext constraintValidatorContext) {
     return anEnum != null && Pattern.compile(regex).matcher(anEnum.name()).matches();
  }
}
