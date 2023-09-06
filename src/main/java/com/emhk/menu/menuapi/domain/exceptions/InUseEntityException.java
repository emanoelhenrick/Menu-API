package com.emhk.menu.menuapi.domain.exceptions;

public class InUseEntityException extends BusinessException {
  public InUseEntityException(String id) {
    super("the entity with id " + id + " is in use");
  }
}
