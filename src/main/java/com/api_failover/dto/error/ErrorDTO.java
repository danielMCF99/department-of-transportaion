package com.api_failover.dto.error;

import java.io.Serializable;

public class ErrorDTO implements Serializable {

  private String message;

  public ErrorDTO(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
