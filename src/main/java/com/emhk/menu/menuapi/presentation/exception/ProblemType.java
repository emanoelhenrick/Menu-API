package com.emhk.menu.menuapi.presentation.exception;

import lombok.Getter;

@Getter
public enum ProblemType {
  RESOURCE_NOT_FOUND("Resource not found.");

  ProblemType(String title) {}
}
