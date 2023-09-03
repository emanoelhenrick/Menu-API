package com.emhk.menu.menuapi.presentation.controllers.establishment;

import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.input.disassembler.EstablishmentDisassembler;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.assembler.EstablishmentAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.input.EstablishmentInput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.EstablishmentOutput;
import com.emhk.menu.menuapi.domain.services.establishment.AddEstablishment;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/establishment")
public class AddEstablishmentController {
  
  @Autowired
  private AddEstablishment addEstablishment;

  @Autowired
  private EstablishmentDisassembler disassembler;

  @Autowired
  private EstablishmentAssembler assembler;

  @PostMapping
  public EstablishmentOutput addNewEstablishment(@Valid @RequestBody EstablishmentInput input) {
    var establishmentToSave = disassembler.toDomainModel(input);
    var establishment = addEstablishment.add(establishmentToSave);
    return assembler.toDTO(establishment);
  }

}
