package com.emhk.menu.menuapi.data.services.establishmentTable;

import com.emhk.menu.menuapi.domain.exceptions.establishment.EstablishmentNotFoundException;
import com.emhk.menu.menuapi.domain.models.EstablishmentTable;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.repository.EstablishmentTableRepository;
import com.emhk.menu.menuapi.domain.services.establishmentTable.AddEstablishmentTable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DbAddEstablishmentTable implements AddEstablishmentTable {

  private final EstablishmentTableRepository establishmentTableRepository;
  private final EstablishmentRepository establishmentRepository;

  DbAddEstablishmentTable(
    EstablishmentTableRepository establishmentTableRepository,
    EstablishmentRepository establishmentRepository
  ) {
    this.establishmentTableRepository = establishmentTableRepository;
    this.establishmentRepository = establishmentRepository;
  }
  @Override
  public EstablishmentTable add(EstablishmentTable establishmentTable, String establishmentId) {
    var establishment = establishmentRepository.findById(UUID.fromString(establishmentId))
      .orElseThrow(() -> new EstablishmentNotFoundException(establishmentId));
    establishmentTable.setEstablishment(establishment);
    return establishmentTableRepository.save(establishmentTable);
  }
}
