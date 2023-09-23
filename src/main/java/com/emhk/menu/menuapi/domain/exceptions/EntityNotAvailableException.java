package com.emhk.menu.menuapi.domain.exceptions;

public class EntityNotAvailableException extends BusinessException {
	public EntityNotAvailableException(String reason) {
		super(reason);
	}
}
