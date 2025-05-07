package com.quocchung.SPRINGBOOT_BASE.utils.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserType {
  @JsonProperty("owner")
  OWNER,
  @JsonProperty("admin")
  ADMIN,

  @JsonProperty("manager")
  MANAGER,

  @JsonProperty("sysadmin")
  SYSADMIN,

  @JsonProperty("user")
  USER;
}
