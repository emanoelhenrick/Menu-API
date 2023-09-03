package com.emhk.menu.menuapi.data.services.establishment;

import com.emhk.menu.menuapi.domain.exceptions.establishment.EstablishmentNotFoundException;
import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class DbLoadEstablishmentTest {

  @InjectMocks
  private DbLoadEstablishment loadEstablishment;

  @Mock
  private EstablishmentRepository establishmentRepository;

  @BeforeEach
  void setup() {

    given(establishmentRepository.findById(any()))
      .willReturn(Optional.of(new Establishment()));
  }

  @Test
  void ShouldThrowIfNoEstablishmentFound() {
    given(establishmentRepository.findById(any()))
      .willThrow(EstablishmentNotFoundException.class);

    assertThatThrownBy(() -> loadEstablishment.load(UUID.randomUUID().toString()))
      .isInstanceOf(EstablishmentNotFoundException.class);
  }

  @Test
  void ShouldReturnsAEstablishmentIfSuccess() {
    var establishment = loadEstablishment.load(UUID.randomUUID().toString());
    assertThat(establishment)
      .isInstanceOf(Establishment.class);
  }
}
