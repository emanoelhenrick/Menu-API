package com.emhk.menu.menuapi.domain.services.dtos.establishment.output.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.EstablishmentOutput;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.EstablishmentShortOutput;

@Component
public class EstablishmentAssembler {

  private final ModelMapper mapper;

  EstablishmentAssembler(ModelMapper modelMapper) {
    this.mapper = modelMapper;
  }
  
  public EstablishmentOutput toDTO(Establishment establishment) {
    return mapper.map(establishment, EstablishmentOutput.class);
  }

  public EstablishmentShortOutput toShortDTO(Establishment establishment) {
    return mapper.map(establishment, EstablishmentShortOutput.class);
  }

  public List<EstablishmentOutput> toDTOCollection(List<Establishment> establishments) {
    return establishments.stream()
      .map(establishment -> toDTO(establishment))
      .toList();
  }

  public List<EstablishmentShortOutput> toShortDTOCollection(List<Establishment> establishments) {
    return establishments.stream()
      .map(establishment -> toShortDTO(establishment))
      .toList();
  }

  
}
