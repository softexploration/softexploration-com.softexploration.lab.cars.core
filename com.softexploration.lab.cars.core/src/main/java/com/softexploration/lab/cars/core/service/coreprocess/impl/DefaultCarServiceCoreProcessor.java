package com.softexploration.lab.cars.core.service.coreprocess.impl;

import java.util.List;
import java.util.function.Function;

import com.softexploration.lab.cars.core.domain.Car;
import com.softexploration.lab.cars.core.service.coreprocess.CarServiceCoreProcessor;

public class DefaultCarServiceCoreProcessor implements CarServiceCoreProcessor {

	private List<Car> carsRepository;

	public void setCarsRepository(final List<Car> carsRepository) {
		this.carsRepository = carsRepository;
	}

	@Override
	public Function<Car, Car> create() {
		return c -> {
			carsRepository.add(c);
			return c;
		};
	}

	@Override
	public Function<Car, Car> update() {
		return c -> {
			carsRepository.set(carsRepository.indexOf(c), c);
			return c;
		};
	}

}
