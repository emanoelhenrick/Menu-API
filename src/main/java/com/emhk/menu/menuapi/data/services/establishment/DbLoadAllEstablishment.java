package com.emhk.menu.menuapi.data.services.establishment;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.services.establishment.LoadAllEstablishment;

@Service
public class DbLoadAllEstablishment implements LoadAllEstablishment {

  @Autowired
  private EstablishmentRepository repository;

  @Override
  public List<Establishment> loadAllByOwner(String id) {
    return repository.findAllByOwnerId(UUID.fromString(id)).orElseThrow();
  }
  
}
