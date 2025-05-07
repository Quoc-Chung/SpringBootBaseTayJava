package com.quocchung.SPRINGBOOT_BASE.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseSuccess extends ResponseEntity<ResponseSuccess.PayLoad> {

    /*- MÔ TẢ DỮ LIỆU TRẢ VỀ CHO PUT , PATCH , DELETE -> NÓ KHÔNG TRẢ VE DU LIEU GI CA  -*/
    public  ResponseSuccess(HttpStatusCode status, String message) {
      super(new PayLoad(status.value(),message),HttpStatus.OK);
    }

    /*- NÓ SẼ TRẢ VỀ DỮ LIỆU POST, GET -*/
    public ResponseSuccess(HttpStatusCode status, String message, Object data) {
      super(new PayLoad(status.value(),message,data), HttpStatus.OK);
    }


    public static class PayLoad{
      private final int status;
      private final String message;
      private Object data;

      public PayLoad(int status, String message) {
        this.status = status;
        this.message = message;
      }

      public PayLoad(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
      }

      public int getStatus() {
        return status;
      }

      public String getMessage() {
        return message;
      }

      public Object getData() {
        return data;
      }

      public void setData(Object data) {
        this.data = data;
      }
    }

}
