package com.emhk.menu.menuapi.data.services.establishment;

import com.emhk.menu.menuapi.domain.exceptions.establishment.EstablishmentNotFoundException;
import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.EstablishmentOutput;
import com.emhk.menu.menuapi.presentation.controllers.dtos.establishment.output.assembler.EstablishmentAssembler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class DbLoadEstablishmentTest {

  @InjectMocks
  private DbLoadEstablishment loadEstablishment;

  @Mock
  private EstablishmentRepository establishmentRepository;

  @Mock
  private EstablishmentAssembler assembler;

  private ModelMapper modelMapper;
  private Establishment fakeEstablishment;

  @BeforeEach
  void setup() {
    modelMapper = new ModelMapper();

    var uuid = "f23901a1-3be4-4d1b-aaaf-b286e453e584";
    fakeEstablishment = new Establishment();
    fakeEstablishment.setId(UUID.fromString(uuid));
    fakeEstablishment.setName("Jurubeba");
  }

  @Test
  void ShouldThrowIfNoEstablishmentFound() {
    var uuid = UUID.randomUUID();

    when(establishmentRepository.findById(uuid))
      .thenThrow(EstablishmentNotFoundException.class);

    assertThrows(
      EstablishmentNotFoundException.class,
      () -> loadEstablishment.load(uuid.toString())
    );
  }

  @Test
  void ShouldReturnsAEstablishmentIfSuccess() {
    when(establishmentRepository.findById(UUID.fromString("f23901a1-3be4-4d1b-aaaf-b286e453e584")))
      .thenReturn(Optional.of(fakeEstablishment));

    when(assembler.toDTO(fakeEstablishment))
      .thenReturn(modelMapper.map(fakeEstablishment, EstablishmentOutput.class));

    var establishment = loadEstablishment.load("f23901a1-3be4-4d1b-aaaf-b286e453e584");

    assertEquals(
        establishment.getId(),
        fakeEstablishment.getId().toString()
      );

  }
}
