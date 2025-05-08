package com.quocchung.SPRINGBOOT_BASE.dto.response;


import com.quocchung.SPRINGBOOT_BASE.utils.enums.Gender;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.UserStatus;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailResponse {
  private Long id;

  private String firstName;


  private String lastName;


  private String email;


  private String phone;


  private Date dateOfBirth;

  private Gender gender;

  private String username;

  private String type;

  private UserStatus status;

}
