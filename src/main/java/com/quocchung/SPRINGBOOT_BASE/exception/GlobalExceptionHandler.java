package com.quocchung.SPRINGBOOT_BASE.exception;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/*- Những thằng nào mà ném ra ngoại lệ thì nó sẽ nhảy đến cai nay -*/
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorResponse handleValidationException(MethodArgumentNotValidException ex, final WebRequest request) {
    String message = ex.getBindingResult().getAllErrors()
        .stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .collect(Collectors.joining(", "));

    return ErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.BAD_REQUEST.value())
        .path(request.getDescription(false).replace("uri=", ""))
        .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
        .message(message)
        .build();
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ErrorResponse handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
    return ErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.NOT_FOUND.value())
        .path(request.getDescription(false).replace("uri=", ""))
        .error(HttpStatus.NOT_FOUND.getReasonPhrase())
        .message("Không tìm thấy tài nguyên: " + ex.getMessage())
        .build();
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
    return ErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.BAD_REQUEST.value())
        .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
        .path(request.getDescription(false).replace("uri=", ""))
        .message("Tham số truyền vào không hợp lệ: " + ex.getName() + " phải có kiểu " + ex.getRequiredType().getSimpleName())
        .build();
  }

  /*
  @ExceptionHandler(ResourceNotFoundException.class)
  public ErrorResponse handleNotFound(ResourceNotFoundException ex, WebRequest request) {
    return ErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.NOT_FOUND.value())
        .error(HttpStatus.NOT_FOUND.getReasonPhrase())
        .path(request.getDescription(false).replace("uri=", ""))
        .message(ex.getMessage())
        .build();
  }
  */

}
