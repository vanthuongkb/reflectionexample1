package com.vanthuong.example.enums;

/**
 * Official blog: http://www.vanthuong.com
 * Learn and share your java knowledge
 */
public enum Action {
  READ("get"),
  ADD("add"),
  UPDATE("update"),
  DELETE("delete");

  private final String value;

  Action(String value) {
    this.value = value;
  }

  public String value() {
    return this.value;
  }
}
