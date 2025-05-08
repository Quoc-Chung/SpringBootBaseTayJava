package com.quocchung.SPRINGBOOT_BASE.dto.response;

import org.springframework.http.ResponseEntity;

public class ResponseFactory {
    /*- Trường hợp trả về dữ liệu có data - */
    public static <T> ResponseEntity<GeneralResponse<T>> success(T data) {
      GeneralResponse<T> geneRalResponse = GeneralResponse.<T>builder()
          .status(ResponseStatus.SUCCESS_STATUS)
          .data(data)
          .extraData(null).build();
      return ResponseEntity.ok(geneRalResponse);
    }
    /* Trương hơp tra vè du lieu co data -*/
  public static <T> ResponseEntity<GeneralResponse<T>> success() {
    GeneralResponse<T> geneRalResponse = GeneralResponse.<T>builder()
        .status(ResponseStatus.SUCCESS_STATUS)
        .extraData(null).build();
    return ResponseEntity.ok(geneRalResponse);
  }





}
