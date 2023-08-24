package com.emhk.menu.menuapi.data.services.establishment;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.services.establishment.LoadEstablishment;

@Service
public class DbLoadEstablishment implements LoadEstablishment{

  @Autowired
  private EstablishmentRepository repository;

  @Override
  public Establishment load(String id) {
    return repository.findById(UUID.fromString(id)).orElseThrow();
  }
  
}
