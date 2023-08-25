package com.emhk.menu.menuapi.presentation.controllers.establishment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.EstablishmentShortOutput;
import com.emhk.menu.menuapi.domain.services.establishment.LoadAllEstablishment;

@RestController
@RequestMapping("/establishment")
public class LoadAllEstablishmentController {

  @Autowired
  private LoadAllEstablishment loadAllEstablishment;

  @GetMapping
  public List<EstablishmentShortOutput> loadAllEstablishmentByOwner(@RequestParam(required = true) String owner) {
    return loadAllEstablishment.loadAllByOwner(owner);
  }
  
}
