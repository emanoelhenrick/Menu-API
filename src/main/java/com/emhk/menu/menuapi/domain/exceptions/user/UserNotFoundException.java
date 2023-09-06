package com.emhk.menu.menuapi.domain.exceptions.user;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;

import java.util.UUID;

public class UserNotFoundException extends EntityNotFoundException {

	public UserNotFoundException(String id) {
		super("there is no User with id " + id);
	}

}
