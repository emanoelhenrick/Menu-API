package com.emhk.menu.menuapi.domain.services.establishment;

import com.emhk.menu.menuapi.domain.services.dtos.establishment.input.EstablishmentInput;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.EstablishmentOutput;

public interface AddEstablishment {
  public EstablishmentOutput add(EstablishmentInput input);
}
