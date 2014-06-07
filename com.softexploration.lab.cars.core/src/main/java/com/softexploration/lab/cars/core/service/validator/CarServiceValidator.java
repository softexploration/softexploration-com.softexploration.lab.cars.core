package com.softexploration.lab.cars.core.service.validator;

import java.util.function.Function;

import com.softexploration.lab.cars.core.domain.Car;
import com.softexploration.lab.cars.core.types.CarEntry;

/**
 * Validation rules for cars operations purposes
 *
 */
public interface CarServiceValidator {

	/**
	 * Returns CarEntry object passed on input if it has correct values set or
	 * InvalidCarEntryStructureException is thrown otherwise. It applies for
	 * creation process.<br/>
	 * An Entry instance has to have an array with 2 or 5 elements. The array
	 * structure maps to Car attributes as following:
	 * <ol>
	 * <li>0 - Car.make</li>
	 * <li>1 - Car.model</li>
	 * <li>2 - Car.year</li>
	 * <li>3 - Car.engine</li>
	 * <li>4 - Car.color</li>
	 * </ol>
	 * 
	 * If array.lenth is 2 then a Car instance is based on Car.make and
	 * Car.model attributes (creating identifier).<br/>
	 * If array.lenth is 5 then all Car attributes can be filled.
	 * 
	 * @return valid CarEntry object
	 * @throws InvalidCarEntryStructureException
	 */
	Function<CarEntry, CarEntry> validateCarEntryForCreate();

	/**
	 * Returns CarEntry object passed on input if it has correct values set or
	 * InvalidCarEntryStructureException is thrown otherwise. It applies for
	 * update process.<br/>
	 * An Entry instance has to have an array with 2 or 5 elements. The array
	 * structure maps to Car attributes as following:
	 * <ol>
	 * <li>0 - Car.make</li>
	 * <li>1 - Car.model</li>
	 * <li>2 - Car.year</li>
	 * <li>3 - Car.engine</li>
	 * <li>4 - Car.color</li>
	 * </ol>
	 * 
	 * If array.lenth is 2 then a Car instance is based on Car.make and
	 * Car.model attributes (creating identifier).<br/>
	 * If array.lenth is 5 then all Car attributes can be filled.
	 * 
	 * @return valid CarEntry object
	 * @throws InvalidCarEntryStructureException
	 */
	Function<CarEntry, CarEntry> validateCarEntryForUpdate();

	/**
	 * Returns Car object passed on input if no Car instance with the same
	 * identifier [make, model] already exists. A DuplicateCarException
	 * exception is thrown otherwise.
	 * 
	 * @return valid Car object
	 * @throws DuplicateCarException
	 */
	Function<Car, Car> validateCarForCreate();

	/**
	 * Returns Car object passed on input if a Car instance with the same
	 * identifier [make, model] already exists. A CarNotFoundException exception
	 * is thrown otherwise.
	 * 
	 * @return valid Car object
	 * @throws CarNotFoundException
	 */
	Function<Car, Car> validateCarForUpdate();
}
