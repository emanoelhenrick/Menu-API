package com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.input.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.input.EstablishmentInput;

@Component
public class EstablishmentDisassembler {

  private final ModelMapper mapper;

  public EstablishmentDisassembler(ModelMapper modelMapper) {
    this.mapper = modelMapper;
  }
  
  public Establishment toDomainModel(EstablishmentInput input) {
    return mapper.map(input, Establishment.class);
  }

  public void copyToDomainObject(EstablishmentInput input, Establishment establishment) {
    mapper.map(input, establishment);
  }

}
