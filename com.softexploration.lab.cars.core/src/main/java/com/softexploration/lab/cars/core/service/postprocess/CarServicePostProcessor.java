package com.softexploration.lab.cars.core.service.postprocess;

import java.util.function.Function;

import com.softexploration.lab.cars.core.domain.Car;

/**
 * Operations performed after core operations on Car instances
 *
 */
public interface CarServicePostProcessor {

	Function<Car, Car> create();

	Function<Car, Car> update();
}
