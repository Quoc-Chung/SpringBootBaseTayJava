package com.quocchung.SPRINGBOOT_BASE.exception;

/*- Những thằng khác mình bt thì nên để vào controller advice còn cách này nữa -*/
public class ResourceNotFoundException extends  RuntimeException {

  public ResourceNotFoundException() {

  }

  public ResourceNotFoundException(String message) {
    super(message);
  }

  public ResourceNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public ResourceNotFoundException(Throwable cause) {
    super(cause);
  }

  public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
