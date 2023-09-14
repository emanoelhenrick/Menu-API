package com.emhk.menu.menuapi.presentation.controllers.dtos.establishmentTable.input.disassembler;

import com.emhk.menu.menuapi.domain.models.EstablishmentTable;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishmentTable.input.EstablishmentTableInput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EstablishmentTableDisassembler {

  private final ModelMapper mapper;

  public EstablishmentTableDisassembler(ModelMapper modelMapper) {
    this.mapper = modelMapper;
  }

  public EstablishmentTable toDomainModel(EstablishmentTableInput input) {
    return mapper.map(input, EstablishmentTable.class);
  }

  public void copyToDomainObject(EstablishmentTableInput input, EstablishmentTable establishment) {
    mapper.map(input, establishment);
  }
}
