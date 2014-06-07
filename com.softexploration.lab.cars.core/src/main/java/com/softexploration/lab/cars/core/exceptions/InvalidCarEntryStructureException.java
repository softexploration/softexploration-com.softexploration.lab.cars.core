package com.softexploration.lab.cars.core.exceptions;

public class InvalidCarEntryStructureException extends RuntimeException {

	private static final long serialVersionUID = 4905139869996413406L;

	public InvalidCarEntryStructureException() {
	}

	public InvalidCarEntryStructureException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCarEntryStructureException(String message) {
		super(message);
	}

}
