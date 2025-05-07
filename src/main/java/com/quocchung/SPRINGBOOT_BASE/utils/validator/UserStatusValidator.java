package com.quocchung.SPRINGBOOT_BASE.utils.validator;

import com.quocchung.SPRINGBOOT_BASE.utils.anotation.UserStatusAnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class UserStatusValidator implements ConstraintValidator<UserStatusAnotation, Enum<?>> {

  private Pattern pattern;

  @Override
  public void initialize(UserStatusAnotation enumPattern) {
    try {
      pattern = Pattern.compile(enumPattern.regexp());
    } catch (PatternSyntaxException e) {
      throw new IllegalArgumentException("Given regex is invalid", e);
    }
  }

  @Override
  public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }

    Matcher m = pattern.matcher(value.name());
    return m.matches();
  }
}

