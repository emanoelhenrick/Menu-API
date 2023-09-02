package com.emhk.menu.menuapi.domain.exceptions.establishment;

public class EstablishmentNotFoundException extends RuntimeException {
  public EstablishmentNotFoundException(String value) {
    super(value);
  }
}
