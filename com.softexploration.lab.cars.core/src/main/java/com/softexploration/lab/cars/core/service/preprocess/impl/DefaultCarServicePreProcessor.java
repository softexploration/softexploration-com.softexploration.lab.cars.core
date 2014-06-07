package com.softexploration.lab.cars.core.service.preprocess.impl;

import java.util.function.Function;

import com.softexploration.lab.cars.core.domain.Car;
import com.softexploration.lab.cars.core.domain.Car.Builder;
import com.softexploration.lab.cars.core.service.preprocess.CarServicePreProcessor;
import com.softexploration.lab.cars.core.types.CarEntry;

public class DefaultCarServicePreProcessor implements CarServicePreProcessor {

	@Override
	public Function<CarEntry, Car> create() {
		return convertCarEntryToCar();
	}

	@Override
	public Function<CarEntry, Car> update() {
		return convertCarEntryToCar();
	}

//	protected Function<CarEntry, Car.Builder> convertCarEntryToBuilder() {
//		return entry -> {
//			final Builder builder = new Car.Builder(entry.getArray()[0], entry.getArray()[1]);
//			if (entry.getArray().length > 4) {
//				builder.year(Integer.valueOf(entry.getArray()[2])).engine(entry.getArray()[3])
//						.color(entry.getArray()[4]);
//			}
//			return builder;
//		};
//	}

	protected Function<CarEntry, Car> convertCarEntryToCar() {
		return entry -> {
			final Builder builder = new Car.Builder(entry.getArray()[0], entry.getArray()[1]);
			if (entry.getArray().length > 4) {
				builder.year(Integer.valueOf(entry.getArray()[2])).engine(entry.getArray()[3])
						.color(entry.getArray()[4]);
			}
			return builder.build();
		};
	}

}
