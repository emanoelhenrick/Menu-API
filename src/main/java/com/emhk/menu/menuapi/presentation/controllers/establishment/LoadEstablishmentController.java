package com.emhk.menu.menuapi.presentation.controllers.establishment;

import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.assembler.EstablishmentAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.EstablishmentOutput;
import com.emhk.menu.menuapi.domain.services.establishment.LoadEstablishment;

@RestController
@RequestMapping("/establishment/{id}")
public class LoadEstablishmentController {

  @Autowired
  private LoadEstablishment loadEstablishment;

  @Autowired
  private EstablishmentAssembler assembler;

  @GetMapping
  public EstablishmentOutput loadEstablishmentById(@PathVariable String id) {
    var establishment = loadEstablishment.load(id);
    return assembler.toDTO(establishment);
  }
}
