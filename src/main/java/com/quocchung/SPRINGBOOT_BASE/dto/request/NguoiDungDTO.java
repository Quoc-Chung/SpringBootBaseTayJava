package com.quocchung.SPRINGBOOT_BASE.dto.request;


import com.quocchung.SPRINGBOOT_BASE.utils.anotation.EnumStatus;
import com.quocchung.SPRINGBOOT_BASE.utils.anotation.GenderEnum;
import com.quocchung.SPRINGBOOT_BASE.utils.anotation.PermissionEnum;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.Gender;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.PERMISSION;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.UserStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungDTO {
  @NotNull(message = "name must not null !")
  private String name;

  /*- Người dùng chỉ được chọn các tuổi từ 19 - 25 không thì bị lõi -*/

  @NotNull(message = "Tuổi không được để trống")
  @Min(value = 19, message = "Tuổi phải từ 19 trở lên")
  @Max(value = 25, message = "Tuổi phải không quá 25")
  private Integer tuoi;


//  @EnumGender(enumClass = Gender.class)
  @GenderEnum(arrayEnum = {Gender.MALE, Gender.FEMALE})
  private Gender gender;


  @EnumStatus(enumClass = UserStatus.class, message = "status must be one of ACTIVE, INACTIVE, NONE")
  private UserStatus status;

  @PermissionEnum(name="permission" ,regex = "^[SYSTEM_ADMIN|ADMIN|MANAGER|USER]$")
  private PERMISSION permission;


}


