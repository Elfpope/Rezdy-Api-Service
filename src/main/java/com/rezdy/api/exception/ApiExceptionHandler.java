package com.rezdy.api.exception;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * It encapsulates custom API exception handling logic.
 * 
 * @author junfeng
 *
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  /*
   * Refine mismatch type exception. For example, http://localhost:12345/lunch?use-by=trues
   * 
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#
   * handleTypeMismatch(org.springframework.beans.TypeMismatchException,
   * org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus,
   * org.springframework.web.context.request.WebRequest)
   */
  @Override
  protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    ApiError apiError = new ApiError(status, "Invalid parameter value.", ex);
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }
}
