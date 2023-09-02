package com.emhk.menu.menuapi.data.services.establishment;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;
import com.emhk.menu.menuapi.domain.exceptions.establishment.AccessDeniedException;
import com.emhk.menu.menuapi.domain.exceptions.user.UserNotFoundException;
import com.emhk.menu.menuapi.domain.models.Establishment;
import com.emhk.menu.menuapi.domain.models.User;
import com.emhk.menu.menuapi.domain.models.UserRole;
import com.emhk.menu.menuapi.domain.repository.EstablishmentRepository;
import com.emhk.menu.menuapi.domain.repository.UserRepository;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.input.EstablishmentInput;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.input.disassembler.EstablishmentDisassembler;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.EstablishmentOutput;
import com.emhk.menu.menuapi.domain.services.dtos.establishment.output.assembler.EstablishmentAssembler;
import com.emhk.menu.menuapi.domain.services.dtos.user.input.UserIdInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DbAddEstablishmentTest {

	@InjectMocks
	private DbAddEstablishment addEstablishment;

	@Mock
	private EstablishmentRepository establishmentRepository;

	@Spy
	private UserRepository userRepository;

	@Spy
	private EstablishmentAssembler assembler;

	@Spy
	private EstablishmentDisassembler disassembler;

	DbAddEstablishmentTest() {
		ModelMapper modelMapper = new ModelMapper();
		assembler = new EstablishmentAssembler(modelMapper);
		disassembler = new EstablishmentDisassembler(modelMapper);
	}

	private User fakeOwner;
	private User fakeUser;
	private EstablishmentInput fakeEstablishmentInput;
	private Establishment fakeEstablishmentSaved;
	private Establishment fakeEstablishment;
	private EstablishmentOutput fakeEstablishmentOutput;

	@BeforeEach
	void setup() {
		var ownerId = UUID.randomUUID();
		fakeOwner = new User();
		fakeOwner.setId(ownerId);
		fakeOwner.setRole(UserRole.OWNER);

		var userId = UUID.randomUUID();
		fakeUser = new User();
		fakeUser.setId(userId);
		fakeUser.setRole(UserRole.CUSTOMER);

		var userIdInput = new UserIdInput();
		fakeEstablishmentInput = new EstablishmentInput();
		userIdInput.setId(ownerId.toString());
		fakeEstablishmentInput.setOwner(userIdInput);
		fakeEstablishmentInput.setName("jurubeba");
		fakeEstablishment = disassembler.toDomainModel(fakeEstablishmentInput);

		var establishmentId = UUID.randomUUID();
		var mapper = new ModelMapper();
		fakeEstablishmentSaved = new Establishment();
		mapper.map(fakeEstablishment, fakeEstablishmentSaved);
		fakeEstablishmentSaved.setId(establishmentId);

		fakeEstablishmentOutput = assembler.toDTO(fakeEstablishmentSaved);
	}

	@Test
	void shouldThrowIfUserNotfound() {
		doThrow(UserNotFoundException.class)
			.when(userRepository).findById(fakeOwner.getId());

		assertThrows(
				UserNotFoundException.class,
				() -> addEstablishment.add(fakeEstablishmentInput)
			);
	}

	@Test
	void shouldReturnAEstablishmentIfUserIsOwner() {
		doReturn(Optional.of(fakeOwner))
			.when(userRepository).findById(fakeOwner.getId());

		doReturn(fakeEstablishmentSaved)
			.when(establishmentRepository).save(fakeEstablishment);

		var establishment = addEstablishment.add(fakeEstablishmentInput);

		assertEquals(
			fakeEstablishmentOutput.getId(),
			establishment.getId()
		);
	}

	@Test
	void shouldThrowIfUserIsNotAOwner() {
		doReturn(Optional.of(fakeUser))
			.when(userRepository).findById(fakeUser.getId());

		var userId = new UserIdInput();
		userId.setId(fakeUser.getId().toString());
		fakeEstablishmentInput.setOwner(userId);

		assertThrows(
			AccessDeniedException.class,
			() -> addEstablishment.add(fakeEstablishmentInput)
		);
	}

}
