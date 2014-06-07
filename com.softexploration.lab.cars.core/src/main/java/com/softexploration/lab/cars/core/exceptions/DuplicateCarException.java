package com.softexploration.lab.cars.core.exceptions;

public class DuplicateCarException extends RuntimeException {

	private static final long serialVersionUID = 7083665875993417523L;

	public DuplicateCarException() {
	}

	public DuplicateCarException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateCarException(String message) {
		super(message);
	}

}
