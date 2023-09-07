package com.emhk.menu.menuapi.presentation.exception;

import lombok.Getter;

@Getter
public enum ProblemType {
  RESOURCE_NOT_FOUND("Resource not found."),
  IN_USE_ENTITY("In use entity."),
  ENTITY_NOT_AVAILABLE("Entity not available.");

  ProblemType(String title) {}
}
