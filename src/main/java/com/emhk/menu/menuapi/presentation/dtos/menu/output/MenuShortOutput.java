package com.emhk.menu.menuapi.presentation.dtos.menu.output;

import com.emhk.menu.menuapi.presentation.dtos.establishment.output.EstablishmentShortOutput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuShortOutput {

  private Long id;
  private String name;
  private EstablishmentShortOutput establishment;

}
