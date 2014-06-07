package com.softexploration.lab.cars.core.service.preprocess;

import java.util.function.Function;

import com.softexploration.lab.cars.core.domain.Car;
import com.softexploration.lab.cars.core.types.CarEntry;

/**
 * Operations performed before core operations on Car instances
 *
 */
public interface CarServicePreProcessor {

	Function<CarEntry, Car> create();

	Function<CarEntry, Car> update();
}
