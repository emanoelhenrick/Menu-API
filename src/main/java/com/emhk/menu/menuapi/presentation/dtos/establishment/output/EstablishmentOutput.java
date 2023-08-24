package com.emhk.menu.menuapi.presentation.dtos.establishment.output;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.emhk.menu.menuapi.domain.models.FormOfPayment;
import com.emhk.menu.menuapi.presentation.dtos.address.AddressOutput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstablishmentOutput {

  private String id;
  private String name;
  private AddressOutput address;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
  private BigDecimal freightRate;
  private List<FormOfPayment> formsOfPayment = new ArrayList<>();

}
