package com.emhk.menu.menuapi.domain.exceptions;

public class InUseEntityException extends BusinessException {
  public InUseEntityException(String reason) {
    super(reason);
  }
}
