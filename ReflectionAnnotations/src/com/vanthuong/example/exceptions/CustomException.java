package com.vanthuong.example.exceptions;

/**
 * Official blog: http://www.vanthuong.com
 * Learn and share your java knowledge
 */
public class CustomException extends Exception {
  public CustomException() {
    super();
  }

  public CustomException(String message) {
    super(message);
  }

  public CustomException(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomException(Throwable cause) {
    super(cause);
  }

}
