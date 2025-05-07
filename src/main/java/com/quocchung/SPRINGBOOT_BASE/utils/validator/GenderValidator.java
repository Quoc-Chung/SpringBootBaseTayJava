package com.quocchung.SPRINGBOOT_BASE.utils.validator;

import com.quocchung.SPRINGBOOT_BASE.utils.anotation.GenderAnotation;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

/*- THAM SỐ THỨ 2 ĐẠI DIỆN CHO CÁI GIÁ TRỊ MÀ TA NHẬP VÀO TỪ BÀN PHÍM -*/
public class GenderValidator implements ConstraintValidator<GenderAnotation, Gender> {

  private Gender[] genders;

  @Override
  public void initialize(GenderAnotation constraint) {
    this.genders = constraint.anyOf();
  }

  @Override
  public boolean isValid(Gender value, ConstraintValidatorContext context) {
    return value == null || Arrays.asList(genders).contains(value);
  }
}