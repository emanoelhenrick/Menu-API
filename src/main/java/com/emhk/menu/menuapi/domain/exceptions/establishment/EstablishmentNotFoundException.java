package com.emhk.menu.menuapi.domain.exceptions.establishment;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;

import java.util.UUID;

public class EstablishmentNotFoundException extends EntityNotFoundException {

  public EstablishmentNotFoundException(String id) {
    super("there is no Establishment with id " + id);
  }

}
