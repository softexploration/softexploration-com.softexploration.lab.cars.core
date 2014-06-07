package com.softexploration.lab.cars.core.service;

import java.util.List;
import java.util.function.Predicate;

import com.softexploration.lab.cars.core.domain.Car;
import com.softexploration.lab.cars.core.types.CarEntry;

/**
 * Service to manage cars
 */
public interface CarService {

	/**
	 * Creates a new car
	 * 
	 * @param entry
	 *            - data to create a new instance
	 * @return new Car instance
	 */
	Car createCar(final CarEntry entry);

	/**
	 * Updates an existing Car instance
	 * 
	 * @param entry
	 *            - data to update an instance
	 * @return updated instance
	 */
	Car updateCar(final CarEntry entry);

	/**
	 * Finds cars matching a predicate
	 * 
	 * @param predicate
	 * @return cars matching a predicate
	 */
	List<Car> findCars(final Predicate<Car> predicate);

	/**
	 * Removes cars matching a predicate
	 * 
	 * @param predicate
	 * @return cars after applying remove
	 */
	List<Car> removeCars(final Predicate<Car> predicate);

	/**
	 * Returns all Car instances
	 * 
	 * @return all Car instances
	 */
	List<Car> getAllCars();
}
