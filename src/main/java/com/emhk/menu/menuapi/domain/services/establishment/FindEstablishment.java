package com.emhk.menu.menuapi.domain.services.establishment;

import com.emhk.menu.menuapi.domain.models.Establishment;

public interface FindEstablishment {
  public Establishment findById(Long id);
}
