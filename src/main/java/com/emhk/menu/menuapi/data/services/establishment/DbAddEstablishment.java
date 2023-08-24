package com.emhk.menu.menuapi.data.services.establishment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.services.establishment.AddEstablishment;

@Service
public class DbAddEstablishment implements AddEstablishment {

  @Autowired
  private EstablishmentRepository repository;

  @Override
  public Establishment add(Establishment establishment) {
    return repository.save(establishment);
  }
  
}
