package com.softexploration.lab.cars.core.domain;

/**
 * Car entity. The make and model attributes create a composite identifier.
 * 
 */
public class Car {

	private String make;
	private String model;
	private int year;
	private String engine;
	private String color;

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public String getEngine() {
		return engine;
	}

	public String getColor() {
		return color;
	}

	private Car(final Builder builder) {
		this.make = builder.make;
		this.model = builder.model;
		this.year = builder.year;
		this.engine = builder.engine;
		this.color = builder.color;
	}

	public static class Builder {

		private String make;
		private String model;
		private int year;
		private String engine;
		private String color;

		public Builder(final String make, final String model) {
			this.make = make;
			this.model = model;
		}

		public Builder year(final int year) {
			this.year = year;
			return this;
		}

		public Builder engine(final String engine) {
			this.engine = engine;
			return this;
		}

		public Builder color(final String color) {
			this.color = color;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + ", engine=" + engine + ", color=" + color
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

}
