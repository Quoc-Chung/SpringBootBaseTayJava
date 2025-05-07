package com.quocchung.SPRINGBOOT_BASE.utils.validator;

import com.quocchung.SPRINGBOOT_BASE.utils.anotation.Phone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone,String> {
  @Override
  public void initialize(Phone phone) {
    ConstraintValidator.super.initialize(phone);
  }

  @Override
  public boolean isValid(String phone, ConstraintValidatorContext context) {
    if (phone == null || phone.isBlank()) {
      return false;
    }
    String[] validPatterns = {
        "^\\d{10}$",                      // 10 số: 0387654321
        "^\\+84\\d{9}$",                  // +84: +84387654321
        "^\\d{3}-\\d{3}-\\d{4}$",         // gạch ngang: 038-765-4321
        "^\\d{3} \\d{3} \\d{4}$",         // cách: 038 765 4321
    };

    for (String pattern : validPatterns) {
      if (phone.matches(pattern)) {
        return true;
      }
    }

    return false;
  }

}
