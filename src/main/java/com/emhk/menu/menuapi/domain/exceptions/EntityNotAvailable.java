package com.emhk.menu.menuapi.domain.exceptions;

public class EntityNotAvailable extends BusinessException {
	public EntityNotAvailable(String reason) {
		super(reason);
	}
}
