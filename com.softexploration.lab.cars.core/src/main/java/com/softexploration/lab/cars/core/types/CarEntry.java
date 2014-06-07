package com.softexploration.lab.cars.core.types;

/**
 * Flat entry with raw data to represent car.
 * 
 */
public class CarEntry {

	private String[] array;

	public CarEntry(final String[] array) {
		this.array = array;
	}

	public String[] getArray() {
		return array;
	}
}