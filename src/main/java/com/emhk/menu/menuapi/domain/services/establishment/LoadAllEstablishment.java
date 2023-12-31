package com.emhk.menu.menuapi.domain.services.establishment;

import java.util.List;

import com.emhk.menu.menuapi.domain.models.Establishment;
import org.springframework.data.domain.Pageable;

public interface LoadAllEstablishment {
  List<Establishment> loadAllByOwner(String username, Pageable pageable);
}
