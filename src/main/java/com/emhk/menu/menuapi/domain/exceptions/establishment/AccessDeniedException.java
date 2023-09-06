package com.emhk.menu.menuapi.domain.exceptions.establishment;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;

public class AccessDeniedException extends BusinessException {
	public AccessDeniedException() {
		super("user does not have required access.");
	}
}
