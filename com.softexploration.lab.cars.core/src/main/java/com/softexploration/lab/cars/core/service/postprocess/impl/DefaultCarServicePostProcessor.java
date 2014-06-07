package com.softexploration.lab.cars.core.service.postprocess.impl;

import java.util.function.Function;

import com.softexploration.lab.cars.core.domain.Car;
import com.softexploration.lab.cars.core.service.postprocess.CarServicePostProcessor;

public class DefaultCarServicePostProcessor implements CarServicePostProcessor {

	@Override
	public Function<Car, Car> create() {
		return c -> c;
	}

	@Override
	public Function<Car, Car> update() {
		return c -> c;
	}

}
