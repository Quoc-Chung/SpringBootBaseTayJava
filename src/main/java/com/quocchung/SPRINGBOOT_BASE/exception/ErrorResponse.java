package com.quocchung.SPRINGBOOT_BASE.exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
   private LocalDateTime timestamp;
   private int status;
   private String path;
   private String error;
   private String message;



}
