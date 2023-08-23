package com.emhk.menu.menuapi.presentation.controllers.establishment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emhk.menu.menuapi.domain.services.AddEstablishment;
import com.emhk.menu.menuapi.presentation.dtos.establishment.input.EstablishmentInput;
import com.emhk.menu.menuapi.presentation.dtos.establishment.input.dissasembler.EstablishmentDisassembler;
import com.emhk.menu.menuapi.presentation.dtos.establishment.output.EstablishmentOutput;
import com.emhk.menu.menuapi.presentation.dtos.establishment.output.assembler.EstablishmentAssembler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/establishment")
public class AddEstablishmentController {
  
  @Autowired
  private AddEstablishment addEstablishment;

  @Autowired
  private EstablishmentAssembler assembler;

  @Autowired
  private EstablishmentDisassembler disassembler;

  @PostMapping
  public EstablishmentOutput addNewEstablishment(@Valid @RequestBody EstablishmentInput input) {
    var newEstablishment = disassembler.toDomainModel(input);
    var establishment = addEstablishment.add(newEstablishment);
    return assembler.toDTO(establishment);
  }

}
