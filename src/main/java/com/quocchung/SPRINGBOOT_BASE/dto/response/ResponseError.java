package com.quocchung.SPRINGBOOT_BASE.dto.response;

public class ResponseError extends ResponseData {

  public ResponseError(int status, String message) {
    super(status, message);
  }
}