package com.emhk.menu.menuapi.domain.exceptions;

public class EntityNotFoundException extends BusinessException {
	public EntityNotFoundException(String reason) {
		super(reason);
	}
}
