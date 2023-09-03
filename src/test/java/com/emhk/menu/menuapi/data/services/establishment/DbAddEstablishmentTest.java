package com.emhk.menu.menuapi.data.services.establishment;

import com.emhk.menu.menuapi.domain.exceptions.establishment.AccessDeniedException;
import com.emhk.menu.menuapi.domain.exceptions.user.UserNotFoundException;
import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.models.User;
import com.emhk.menu.menuapi.domain.models.UserRole;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DbAddEstablishmentTest {

	@InjectMocks
	private DbAddEstablishment addEstablishment;

	@Mock
	private EstablishmentRepository establishmentRepository;

	@Mock
	private UserRepository userRepository;

	private Establishment fakeEstablishment;

	@BeforeEach
	void setup() {
		fakeEstablishment = new Establishment();
		var fakeOwner = new User();
		fakeOwner.setId(UUID.randomUUID());
		fakeOwner.setRole(UserRole.OWNER);
		fakeEstablishment.setOwner(fakeOwner);

		given(userRepository.findById(any()))
			.willReturn(Optional.of(fakeOwner));

//		given(establishmentRepository.save(any()))
//			.willReturn(Optional.of(fakeEstablishment));
	}

	@Test
	void shouldThrowIfUserNotfound() {
		given(userRepository.findById(any()))
			.willThrow(UserNotFoundException.class);

		assertThatThrownBy(() -> addEstablishment.add(fakeEstablishment))
			.isInstanceOf(UserNotFoundException.class);
	}

	@Test
	void shouldThrowIfUserIsNotAOwner() {
		var customer = new User();
		customer.setRole(UserRole.CUSTOMER);
		customer.setId(UUID.randomUUID());
		fakeEstablishment.setOwner(customer);

		given(userRepository.findById(any()))
			.willReturn(Optional.of(customer));

		assertThatThrownBy(() -> addEstablishment.add(fakeEstablishment))
			.isInstanceOf(AccessDeniedException.class);
	}

//	@Test
//	@Disabled
//	void shouldReturnAEstablishmentIfUserIsOwner() {
//		given(establishmentRepository.save(any()))
//			.willReturn(fakeEstablishment);
//
//		var establishment = addEstablishment.add(fakeEstablishment);
//
//		assertThat(establishment)
//			.isInstanceOf(Establishment.class);
//	}



}
