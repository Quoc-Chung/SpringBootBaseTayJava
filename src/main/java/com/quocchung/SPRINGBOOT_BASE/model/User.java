package com.quocchung.SPRINGBOOT_BASE.model;


import com.quocchung.SPRINGBOOT_BASE.utils.anotation.UserStatusAnotation;
import com.quocchung.SPRINGBOOT_BASE.utils.anotation.UserTypeAnotation;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.Gender;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.UserStatus;
import com.quocchung.SPRINGBOOT_BASE.utils.enums.UserType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class User extends AbstractEntity<Long> {

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "date_of_birth")
  @Temporal(TemporalType.DATE)
  private Date dateOfBirth;





  @Enumerated(EnumType.STRING)
  @Column(name = "gender", columnDefinition = "VARCHAR(10)")
  private Gender gender;


  @Column(name = "phone")
  private String phone;

  @Column(name = "email")
  private String email;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;



  @Enumerated(EnumType.STRING)
  @Column(name = "type", columnDefinition = "ENUM('OWNER','ADMIN','USER','MANAGER','SYSADMIN')")

  private UserType type;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", columnDefinition = "ENUM('ACTIVE','INACTIVE','NONE')")
  private UserStatus status;


}