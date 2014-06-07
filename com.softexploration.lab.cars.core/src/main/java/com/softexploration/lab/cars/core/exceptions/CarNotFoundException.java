package com.softexploration.lab.cars.core.exceptions;

public class CarNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1714997220357299713L;

	public CarNotFoundException() {
	}

	public CarNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarNotFoundException(String message) {
		super(message);
	}

}
