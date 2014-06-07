package com.softexploration.lab.cars.core.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.softexploration.lab.cars.core.domain.Car;
import com.softexploration.lab.cars.core.exceptions.CarNotFoundException;
import com.softexploration.lab.cars.core.exceptions.DuplicateCarException;
import com.softexploration.lab.cars.core.exceptions.InvalidCarEntryStructureException;
import com.softexploration.lab.cars.core.service.CarService;
import com.softexploration.lab.cars.core.service.coreprocess.impl.DefaultCarServiceCoreProcessor;
import com.softexploration.lab.cars.core.service.postprocess.impl.DefaultCarServicePostProcessor;
import com.softexploration.lab.cars.core.service.preprocess.impl.DefaultCarServicePreProcessor;
import com.softexploration.lab.cars.core.service.util.CarUtils;
import com.softexploration.lab.cars.core.service.validator.impl.DefaultCarServiceValidator;
import com.softexploration.lab.cars.core.util.CarSampler;

public class DefaultCarServiceTest {

	private CarService carService;
	private final CarUtils carUtils = new CarUtils();

	@Before
	public void setUp() {
		carService = null;
	}

	@After
	public void tearDown() {
		carService = null;
	}

	@Test(expected = InvalidCarEntryStructureException.class)
	public void testInvalidCarEntryStructure() {
		initCarService(Lists.newArrayList());

		final String[] input = { "mercedes" };
		getCarService().createCar(CarSampler.carEntry(input));
	}

	@Test
	public void testCreateCarMandatoryAttributes() {
		initCarService(Lists.newArrayList());

		final String[] input = { "mercedes", "e-klasse" };
		getCarService().createCar(CarSampler.carEntry(input));

		Assert.assertEquals(1, getCarService().getAllCars().size());
		Assert.assertThat(getCarService().getAllCars(), hasItem(CarSampler.car("mercedes", "e-klasse")));
	}

	@Test
	public void testCreateCarAllAttributes() {
		initCarService(Lists.newArrayList());

		final String[] input = { "opel", "astra", "2010", "1.7 CDTI", "silver" };
		getCarService().createCar(CarSampler.carEntry(input));

		Assert.assertEquals(1, getCarService().getAllCars().size());
		Assert.assertThat(getCarService().getAllCars(),
				hasItem(CarSampler.car("opel", "astra", Integer.valueOf("2010"), "1.7 CDTI", "silver")));
	}

	@Test(expected = DuplicateCarException.class)
	public void testCreateCarDuplicate() {
		initCarService(Lists
				.newArrayList(CarSampler.car("opel", "astra", Integer.valueOf("2010"), "1.7 CDTI", "silver")));

		final String[] input = { "opel", "astra", "2011", "1.9 CDTI", "black" };
		getCarService().createCar(CarSampler.carEntry(input));
	}

	@Test
	public void testUpdateCar() {
		initCarService(Lists.newArrayList(CarSampler.car("audi", "a6", Integer.valueOf("2007"), "3.0 TDI", "black"),
				CarSampler.car("opel", "astra", Integer.valueOf("2010"), "1.7 CDTI", "silver"),
				CarSampler.car("audi", "a4", Integer.valueOf("2008"), "2.0 TDI", "blue")));

		final String[] input = { "opel", "astra", "2011", "1.9 CDTI", "black" };
		final Car updatedObject = getCarService().updateCar(CarSampler.carEntry(input));

		// returned object has properly set attributes
		Assert.assertEquals(CarSampler.car("opel", "astra", Integer.valueOf("2010"), "1.9 CDTI", "black"),
				updatedObject);

		// updated object can be found and non-updated cars are untouched
		Assert.assertThat(
				getCarService().getAllCars(),
				hasItems(updatedObject, CarSampler.car("audi", "a4", Integer.valueOf("2008"), "2.0 TDI", "blue"),
						CarSampler.car("audi", "a6", Integer.valueOf("2007"), "3.0 TDI", "black")));

		// collection size is unchanged
		Assert.assertEquals(3, getCarService().getAllCars().size());
	}

	@Test(expected = CarNotFoundException.class)
	public void testUpdateCarNotFound() {
		initCarService(Lists
				.newArrayList(CarSampler.car("opel", "astra", Integer.valueOf("2010"), "1.7 CDTI", "silver")));

		final String[] input = { "opel", "vectra", "2011", "1.9 CDTI", "black" };
		getCarService().updateCar(CarSampler.carEntry(input));
	}

	@Test
	public void testFindGermanCars() {
		initCarService(CarSampler.createMiscellaneousCars());

		Assert.assertThat(CarSampler.createGermanCars(), equalTo(getCarService().findCars(carUtils.isGerman())));
	}

	@Test
	public void testRemoveCars() {
		initCarService(CarSampler.createMiscellaneousCars());

		Assert.assertThat(CarSampler.createGermanCars(),
				equalTo(getCarService().removeCars(carUtils.isGerman().negate())));
	}

	private void initCarService(final List<Car> cars) {
		final DefaultCarService service = new DefaultCarService();
		service.setCarsRepository(cars);
		service.setCarServicePreProcessor(new DefaultCarServicePreProcessor());
		final DefaultCarServiceCoreProcessor carServiceCoreProcessor = new DefaultCarServiceCoreProcessor();
		carServiceCoreProcessor.setCarsRepository(cars);
		service.setCarServiceCoreProcessor(carServiceCoreProcessor);
		service.setCarServicePostProcessor(new DefaultCarServicePostProcessor());
		final DefaultCarServiceValidator carServiceValidator = new DefaultCarServiceValidator();
		carServiceValidator.setCarsRepository(cars);
		service.setCarServiceValidator(carServiceValidator);
		carService = service;
	}

	private CarService getCarService() {
		return carService;
	}
}
