package com.quocchung.SPRINGBOOT_BASE.dto.response;

import java.io.Serializable;
import java.util.Map;
import lombok.Data;

@Data
/* - RESPONSE TR VỀ Ở DẠNG BÌNH THƯỜNG -*/
public class GeneralResponse<T> implements Serializable {
  private ResponseStatus status;
  private T data;

  /* - BỔ XUNG DỮ LIỆU THÊM CHO DATA -*/
  private Map<String, Object> extraData;


  public GeneralResponse() {
  }

  public GeneralResponse(ResponseStatus status) {
    this.status = status;
  }

  public GeneralResponse(ResponseStatus status, T data, Map<String, Object> extraData) {
    this.status = status;
    this.data = data;
    this.extraData = extraData;
  }
}
