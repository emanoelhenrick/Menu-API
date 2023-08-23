package com.emhk.menu.menuapi.presentation.controllers.establishment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emhk.menu.menuapi.domain.services.establishment.LoadEstablishment;
import com.emhk.menu.menuapi.presentation.dtos.establishment.output.EstablishmentOutput;
import com.emhk.menu.menuapi.presentation.dtos.establishment.output.assembler.EstablishmentAssembler;

@RestController
@RequestMapping("/establishment")
public class LoadEstablishmentController {

  @Autowired
  private LoadEstablishment loadEstablishment;
  
  @Autowired
  private EstablishmentAssembler assembler;

  @GetMapping("/{id}")
  public EstablishmentOutput loadEstablishmentById(@PathVariable Long id) {
    return assembler.toDTO(loadEstablishment.load(id));
  }
}
