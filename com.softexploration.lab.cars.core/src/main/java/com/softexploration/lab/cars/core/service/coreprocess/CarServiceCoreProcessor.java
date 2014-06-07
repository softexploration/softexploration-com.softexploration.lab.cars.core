package com.softexploration.lab.cars.core.service.coreprocess;

import java.util.function.Function;

import com.softexploration.lab.cars.core.domain.Car;

/**
 * Core operations performed on Car instances
 *
 */
public interface CarServiceCoreProcessor {

	Function<Car, Car> create();

	Function<Car, Car> update();
}
