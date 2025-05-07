package com.quocchung.SPRINGBOOT_BASE.utils.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Gender {
  @JsonProperty("male")
  MALE,
  @JsonProperty("female")
  FEMALE,
  @JsonProperty("other")
  OTHER;

}