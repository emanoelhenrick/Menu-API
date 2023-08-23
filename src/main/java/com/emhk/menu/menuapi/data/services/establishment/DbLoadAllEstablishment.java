package com.emhk.menu.menuapi.data.services.establishment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.services.establishment.LoadAllEstablishment;
import com.emhk.menu.menuapi.infra.repository.EstablishmentRepository;

public class DbLoadAllEstablishment implements LoadAllEstablishment {

  @Autowired
  private EstablishmentRepository repository;

  @Override
  public List<Establishment> loadAllByOwner(Long id) {
    return repository.findByOwner(id);
  }
  
}
