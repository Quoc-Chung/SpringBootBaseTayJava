package com.quocchung.SPRINGBOOT_BASE.utils.enums;


import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserStatus {
  @JsonProperty("active")
  ACTIVE,
  @JsonProperty("inactive")
  INACTIVE,
  @JsonProperty("none")
  NONE;
}

/*
  + @JsonProperty("tên_mới")
  -> Anotation này được dùng khi chuyển đổi JSON  (serialize/deserialize).

  + Nó chỉ định tên mà enum sẽ hiển thị khi xuất nhập JSON.

  + Khi chuyển object chứa Gender.MALE sang JSON:
  "gender": "male"


  + @Enumerated(EnumType.STRING) Lưu giá trị enum dưới dạng String nằm
  bên trong của database, thay vì số nguyên.
  enum Gender { MALE, FEMALE }

  Với EnumType.STRING: lưu là "MALE" hoặc "FEMALE" trong DB.

  + SqlTypes.NAMED_ENUM giúp Hibernate hiểu rằng bạn muốn lưu enum theo tên thay vì số.

  + Tổng kết:
       @Enumerated(EnumType.STRING)	Lưu enum dưới dạng chuỗi

       @JdbcTypeCode(SqlTypes.NAMED_ENUM)	Cho Hibernate biết enum là kiểu được đặt tên rõ ràng trong JDBC

       @Column(name = "...")	Chỉ định tên cột tương ứng trong DB

       @JsonProperty("...")	Đổi tên enum khi chuyển đổi JSON (rất hữu ích cho API client/frontend)
*/

