package com.emhk.menu.menuapi.domain.services.establishment;

import java.util.List;

import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.EstablishmentShortOutput;


public interface LoadAllEstablishment {
  public List<EstablishmentShortOutput> loadAllByOwner(String id);
}
