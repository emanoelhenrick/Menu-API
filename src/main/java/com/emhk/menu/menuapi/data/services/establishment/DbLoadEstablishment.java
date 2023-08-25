package com.emhk.menu.menuapi.data.services.establishment;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.EstablishmentOutput;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.assembler.EstablishmentAssembler;
import com.emhk.menu.menuapi.domain.services.establishment.LoadEstablishment;

@Service
public class DbLoadEstablishment implements LoadEstablishment{

  private final EstablishmentRepository establishmentRepository;
  private final EstablishmentAssembler assembler;

  DbLoadEstablishment(
    EstablishmentRepository establishmentRepository,
    EstablishmentAssembler assembler
  ) {
    this.establishmentRepository = establishmentRepository;
    this.assembler = assembler;
  }

  @Override
  public EstablishmentOutput load(String id) {
    return assembler.toDTO(establishmentRepository.findById(UUID.fromString(id)).orElseThrow());
  }
  
}
