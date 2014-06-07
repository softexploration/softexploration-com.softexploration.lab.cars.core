package com.softexploration.lab.cars.core.service.impl;

import java.util.List;
import java.util.function.Predicate;

import com.google.common.collect.Lists;
import com.softexploration.lab.cars.core.domain.Car;
import com.softexploration.lab.cars.core.service.CarService;
import com.softexploration.lab.cars.core.service.coreprocess.CarServiceCoreProcessor;
import com.softexploration.lab.cars.core.service.postprocess.CarServicePostProcessor;
import com.softexploration.lab.cars.core.service.preprocess.CarServicePreProcessor;
import com.softexploration.lab.cars.core.service.validator.CarServiceValidator;
import com.softexploration.lab.cars.core.types.CarEntry;

public class DefaultCarService implements CarService {

	private List<Car> carsRepository;

	private CarServiceValidator carServiceValidator;
	private CarServicePreProcessor carServicePreProcessor;
	private CarServiceCoreProcessor carServiceCoreProcessor;
	private CarServicePostProcessor carServicePostProcessor;

	public void setCarsRepository(final List<Car> cars) {
		this.carsRepository = cars;
	}

	public void setCarServiceValidator(final CarServiceValidator carServiceValidator) {
		this.carServiceValidator = carServiceValidator;
	}

	public void setCarServicePreProcessor(final CarServicePreProcessor carServicePreProcessor) {
		this.carServicePreProcessor = carServicePreProcessor;
	}

	public void setCarServiceCoreProcessor(final CarServiceCoreProcessor carServiceCoreProcessor) {
		this.carServiceCoreProcessor = carServiceCoreProcessor;
	}

	public void setCarServicePostProcessor(final CarServicePostProcessor carServicePostProcessor) {
		this.carServicePostProcessor = carServicePostProcessor;
	}

	protected List<Car> getCars() {
		return Lists.newArrayList(carsRepository);
	}

	@Override
	public Car createCar(final CarEntry entry) {
		return carServicePostProcessor
				.create()
				.compose(
						carServiceCoreProcessor.create().compose(
								carServiceValidator.validateCarForCreate().compose(
										carServicePreProcessor.create().compose(
												carServiceValidator.validateCarEntryForCreate())))).apply(entry);
	}

	@Override
	public Car updateCar(final CarEntry entry) {
		return carServiceCoreProcessor
				.update()
				.compose(
						carServiceValidator.validateCarForUpdate().compose(
								carServicePreProcessor.update()
										.compose(carServiceValidator.validateCarEntryForUpdate())))
				.andThen(carServicePostProcessor.update()).apply(entry);
	}

	@Override
	public List<Car> findCars(final Predicate<Car> predicate) {
		final List<Car> ret = Lists.newLinkedList();
		carsRepository.stream().filter(predicate).forEach(c -> {
			ret.add(c);
		});
		return ret;
	}

	@Override
	public List<Car> removeCars(final Predicate<Car> predicate) {
		carsRepository.removeIf(predicate);
		return getCars();
	}

	@Override
	public List<Car> getAllCars() {
		return getCars();
	}

}
