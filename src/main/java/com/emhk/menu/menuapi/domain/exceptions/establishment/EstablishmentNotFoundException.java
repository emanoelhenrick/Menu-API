package com.emhk.menu.menuapi.domain.exceptions.establishment;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;

import java.util.UUID;

public class EstablishmentNotFoundException extends EntityNotFoundException {

  public EstablishmentNotFoundException(String reason) {
    super(reason);
  }

  public EstablishmentNotFoundException(UUID id) {
    super("there is no Establishment with id " + id);
  }

}
