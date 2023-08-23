package com.emhk.menu.menuapi.data.services.establishment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.services.establishment.LoadEstablishment;
import com.emhk.menu.menuapi.infra.repository.EstablishmentRepository;

@Service
public class DbLoadEstablishment implements LoadEstablishment{

  @Autowired
  private EstablishmentRepository repository;

  @Override
  public Establishment load(Long id) {
    return repository.findById(id).orElseThrow();
  }
  
}
