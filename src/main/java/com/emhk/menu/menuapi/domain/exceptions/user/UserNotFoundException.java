package com.emhk.menu.menuapi.domain.exceptions.user;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String value) {
		super(value);
	}
}
