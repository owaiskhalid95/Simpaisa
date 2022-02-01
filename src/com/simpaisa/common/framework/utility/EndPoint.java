package com.simpaisa.common.framework.utility;

public enum EndPoint {

  VERIFY_PAYMENT("verify"),
  GET_OTP("findOTP"),
  MAKE_TRANSACTION("initiate"),
  SAVE("save");

  private final String value;

  EndPoint(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
