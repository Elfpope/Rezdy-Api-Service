package com.rezdy.api.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rezdy.api.util.Constants;

/**
 * Encapsulate the top level API error and produce user-friendly messages.
 * 
 * @author junfeng
 *
 */
public class ApiError {

  private HttpStatus status;
  private String message;
  private String debugMessage;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
  private LocalDateTime timestamp;

  private ApiError() {
    timestamp = LocalDateTime.now();
  }

  public ApiError(HttpStatus status) {
    this();
    this.status = status;
  }

  public ApiError(HttpStatus status, Throwable ex) {
    this(status);
    message = "Unexpected error";
    debugMessage = ex.getLocalizedMessage();
  }

  public ApiError(HttpStatus status, String message, Throwable ex) {
    this(status, ex);
    this.message = message;
  }

  /**
   * @return the status
   */
  public HttpStatus getStatus() {
    return status;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @return the debugMessage
   */
  public String getDebugMessage() {
    return debugMessage;
  }

  /**
   * @return the timestamp
   */
  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}
