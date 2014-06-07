package com.softexploration.lab.cars.core.service.util;

import java.util.function.Predicate;

import com.softexploration.lab.cars.core.domain.Car;

public class CarUtils {

	public Predicate<Car> isGerman() {
		return c -> isAudi().or(isMercedes()).or(isOpel()).or(isPorsche()).or(isVw()).or(isBmw()).test(c);
	}

	public Predicate<Car> isAudi() {
		return c -> "audi".equalsIgnoreCase(c.getMake());
	}

	public Predicate<Car> isOpel() {
		return c -> "opel".equalsIgnoreCase(c.getMake());
	}

	public Predicate<Car> isMercedes() {
		return c -> "mercedes".equalsIgnoreCase(c.getMake());
	}

	public Predicate<Car> isPorsche() {
		return c -> "porsche".equalsIgnoreCase(c.getMake());
	}

	public Predicate<Car> isVw() {
		return c -> "volkswagen".equalsIgnoreCase(c.getMake());
	}

	public Predicate<Car> isBmw() {
		return c -> "bmw".equalsIgnoreCase(c.getMake());
	}

}
