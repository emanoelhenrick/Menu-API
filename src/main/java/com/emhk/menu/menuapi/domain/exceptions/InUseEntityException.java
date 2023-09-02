package com.emhk.menu.menuapi.domain.exceptions;

public class InUseEntityException extends Exception {
    InUseEntityException(String value) {
        super(value);
    }
}
