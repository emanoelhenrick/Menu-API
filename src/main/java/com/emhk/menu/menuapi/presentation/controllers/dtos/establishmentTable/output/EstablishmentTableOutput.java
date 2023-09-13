package com.emhk.menu.menuapi.presentation.controllers.dtos.establishmentTable.output;

import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.EstablishmentShortOutput;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstablishmentTableOutput {

  private Long id;
  private int number;
  private EstablishmentShortOutput establishment;
  private Boolean isBusy;
  private Boolean active;

}
