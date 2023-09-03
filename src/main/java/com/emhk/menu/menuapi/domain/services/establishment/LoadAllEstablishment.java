package com.emhk.menu.menuapi.domain.services.establishment;

import java.util.List;

import com.emhk.menu.menuapi.domain.models.Establishment;

public interface LoadAllEstablishment {
  public List<Establishment> loadAllByOwner(String id);
}
