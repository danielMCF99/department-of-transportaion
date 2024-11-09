package com.api_failover.controller.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api_failover.dto.error.ErrorDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionController {

  @ExceptionHandler(value = EntityNotFoundException.class)
  private ErrorDTO handleEntityNotFoundException(EntityNotFoundException exception) {
    return new ErrorDTO(exception.getMessage());
  }
}
