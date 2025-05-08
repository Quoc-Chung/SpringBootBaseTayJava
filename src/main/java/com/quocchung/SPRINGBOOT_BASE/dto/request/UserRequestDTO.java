package com.quocchung.SPRINGBOOT_BASE.dto.request;
import static com.quocchung.SPRINGBOOT_BASE.utils.enums.Gender.FEMALE;
import static com.quocchung.SPRINGBOOT_BASE.utils.enums.Gender.MALE;
import static com.quocchung.SPRINGBOOT_BASE.utils.enums.Gender.OTHER;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.quocchung.SPRINGBOOT_BASE.utils.anotation.GenderAnotation;
import com.quocchung.SPRINGBOOT_BASE.utils.anotation.UserStatusAnotation;
import com.quocchung.SPRINGBOOT_BASE.utils.anotation.UserTypeAnotation;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.Gender;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.UserStatus;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.UserType;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO implements Serializable {
       @NotBlank(message = "firstName must be not blank") // Khong cho phep gia tri blank
       private String firstName;

       @NotNull(message = "lastName must be not null") // Khong cho phep gia tri null
       private String lastName;

       @Email(message = "email invalid format") // Chi chap nhan nhung gia tri dung dinh dang email
       private String email;


       private String phone;

       @NotNull(message = "dateOfBirth must be not null")
       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
       @JsonFormat(pattern = "MM/dd/yyyy")
       private Date dateOfBirth;


       /*- Gender thuộc trong các cái này -*/
       @GenderAnotation(anyOf = {MALE, FEMALE, OTHER})
       private Gender gender;

       @NotNull(message = "username must be not null")
       private String username;

       @NotNull(message = "password must be not null")
       private String password;

       @NotNull(message = "type must be not null")
       /* - Chúng ta sẽ so sánh giá trị của String với các giá trị trong enum UserType không -*/
       /*-  Cách này giống cách trên nhưng tốt hơn vì ta không phải liệt kê quá nhiều enum -*/
       @UserTypeAnotation(name = "type", enumClass = UserType.class)
       private UserType type;

       @UserStatusAnotation(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
       private UserStatus status;

       @NotEmpty(message = "addresses can not empty")
       private Set<AddressDTO> addresses;


       public UserRequestDTO(String firstName, String lastName, String email, String phone) {
              this.firstName = firstName;
              this.lastName = lastName;
              this.email = email;
              this.phone = phone;
       }

}