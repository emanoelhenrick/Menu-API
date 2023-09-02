package com.emhk.menu.menuapi.domain.exceptions.establishment;

public class AccessDeniedException extends RuntimeException {
	public AccessDeniedException() {
		super("user does not have required access.");
	}
}
