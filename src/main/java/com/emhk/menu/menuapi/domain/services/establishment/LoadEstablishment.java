package com.emhk.menu.menuapi.domain.services.establishment;

import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.EstablishmentOutput;

public interface LoadEstablishment {
  public EstablishmentOutput load(String id);
}
