package com.emhk.menu.menuapi.domain.services.establishment;

import java.util.List;

import com.emhk.menu.menuapi.domain.models.Establishment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoadAllEstablishment {
  public Page<Establishment> loadAllByOwner(String username, Pageable pageable);
}
