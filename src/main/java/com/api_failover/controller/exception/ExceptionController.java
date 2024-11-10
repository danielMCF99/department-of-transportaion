package com.api_failover.controller.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api_failover.dto.error.ErrorDTO;

@RestControllerAdvice
public class ExceptionController {

  @ExceptionHandler(value = Exception.class)
  private ErrorDTO handleEntityNotFoundException(Exception exception) {
    return new ErrorDTO(exception.getMessage());
  }
}
