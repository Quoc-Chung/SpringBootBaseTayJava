package com.quocchung.SPRINGBOOT_BASE.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;


@Data
@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable> implements Serializable   {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  T id;

    @CreatedBy
    @Column(name = "create_by")
    T createBy;

    @LastModifiedBy
    @Column(name = "updated_by")
    T updatedBy;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}

/*
 +  @Temporal dùng khi bạn làm việc với kiểu java.util.Date
                                             java.util.Calendar trong JPA/Hibernate.

 + JPA cần biết bạn muốn lưu phần nào của giá trị ngày giờ (vì Date chứa cả ngày và giờ).

           + DATE	Chỉ lưu ngày	yyyy-MM-dd
           + TIME	Chỉ lưu giờ phút giây	HH:mm:ss
           + TIMESTAMP (phổ biến)	Lưu cả ngày và giờ	yyyy-MM-dd HH:mm:ss

  +  @CreationTimestamp : Tự động gán ngày giờ tạo bản ghi khi bạn lưu lần đầu (INSERT).
                          Không cập nhật lại khi bạn chỉnh sửa bản ghi sau đó.
  + @UpdateTimestamp: Tự động cập nhật thời gian mỗi khi bản ghi bị sửa đổi (UPDATE).
                      Dùng để biết thời điểm cuối cùng dữ liệu được chỉnh sửa.
  +  Tự động lưu lại ai (người dùng nào) đã tạo bản ghi, cần cấu hình trong Spring Security hoặc AuditorAware<T>
  +  @LastModifiedBy	Người cập nhật cuối cùng

*/