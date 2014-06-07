package com.softexploration.lab.cars.core.service.validator.impl;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.softexploration.lab.cars.core.domain.Car;
import com.softexploration.lab.cars.core.exceptions.CarNotFoundException;
import com.softexploration.lab.cars.core.exceptions.DuplicateCarException;
import com.softexploration.lab.cars.core.exceptions.InvalidCarEntryStructureException;
import com.softexploration.lab.cars.core.service.validator.CarServiceValidator;
import com.softexploration.lab.cars.core.types.CarEntry;

public class DefaultCarServiceValidator implements CarServiceValidator {

	private List<Car> carsRepository;

	public void setCarsRepository(final List<Car> carsRepository) {
		this.carsRepository = carsRepository;
	}

	@Override
	public Function<CarEntry, CarEntry> validateCarEntryForCreate() {
		return validateCarEntry();
	}

	@Override
	public Function<CarEntry, CarEntry> validateCarEntryForUpdate() {
		return validateCarEntry();
	}

	protected Function<CarEntry, CarEntry> validateCarEntry() {
		return entry -> {
			if (validateCarEntryMandatoryContent().test(entry)) {
				return entry;
			} else {
				throw new InvalidCarEntryStructureException("CarEntry should provide 2 mandatory properties. Actual:"
						+ entry.getArray().length);
			}

		};
	}

	protected Predicate<CarEntry> validateCarEntryMandatoryContent() {
		return entry -> entry.getArray().length > 1;
	}

	@Override
	public Function<Car, Car> validateCarForUpdate() {
		return c -> {
			if (!carsRepository.contains(c)) {
				throw new CarNotFoundException(c.toString() + " does not exist");
			} else {
				return c;
			}
		};
	}

	@Override
	public Function<Car, Car> validateCarForCreate() {
		return c -> {
			if (carsRepository.contains(c)) {
				throw new DuplicateCarException("Car [make=" + c.getMake() + ", model=" + c.getModel()
						+ "] already exists");
			} else {
				return c;
			}
		};
	}
}
