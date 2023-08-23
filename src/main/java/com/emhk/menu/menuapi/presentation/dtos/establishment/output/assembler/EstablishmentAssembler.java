package com.emhk.menu.menuapi.presentation.dtos.establishment.output.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.presentation.dtos.establishment.output.EstablishmentOutput;

@Component

public class EstablishmentAssembler {

  @Autowired
  private ModelMapper mapper;
  
  public EstablishmentOutput toDTO(Establishment establishment) {
    return mapper.map(establishment, EstablishmentOutput.class);
  }

  public List<EstablishmentOutput> toDTOCollection(List<Establishment> establishments) {
    return establishments.stream()
      .map(establishment -> toDTO(establishment))
      .toList();
  }
}
