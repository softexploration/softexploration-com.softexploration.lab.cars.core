package com.softexploration.lab.cars.core.util;

import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.softexploration.lab.cars.core.domain.Car;
import com.softexploration.lab.cars.core.types.CarEntry;

public class CarSampler {

	public static List<Car> createGermanCars() {
		return Lists.newArrayList(car("opel", "astra"), car("opel", "vectra"), car("audi", "a4"), car("audi", "a6"),
				car("porsche", "911"), car("mercedes", "slk"));
	}

	public static List<Car> createCzechCars() {
		return Lists.newArrayList(car("skoda", "octavia"), car("skoda", "superb"));
	}

	public static List<Car> createMiscellaneousCars() {
		return Lists.newArrayList(Iterables.concat(createGermanCars(), createCzechCars()));
	}

	public static Car car(final String make, final String model) {
		return new Car.Builder(make, model).build();
	}

	public static Car car(final String make, final String model, final int year, final String engine, final String color) {
		return new Car.Builder(make, model).year(year).engine(engine).color(color).build();
	}

	public static CarEntry carEntry(final String[] array) {
		return new CarEntry(array);
	}
}
