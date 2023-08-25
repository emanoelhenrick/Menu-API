package com.emhk.menu.menuapi.data.services.establishment;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.EstablishmentShortOutput;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.assembler.EstablishmentAssembler;
import com.emhk.menu.menuapi.domain.services.establishment.LoadAllEstablishment;

@Service
public class DbLoadAllEstablishment implements LoadAllEstablishment {

  @Autowired
  private EstablishmentRepository establishmentRepository;

  @Autowired
  private EstablishmentAssembler assembler;

  @Override
  public List<EstablishmentShortOutput> loadAllByOwner(String id) {
    var establishments = establishmentRepository.findAllByOwnerId(UUID.fromString(id)).orElseThrow();
    return assembler.toShortDTOCollection(establishments);
  }
  
}
