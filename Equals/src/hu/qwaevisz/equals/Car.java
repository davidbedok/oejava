package hu.qwaevisz.equals;

public class Car {

	private final int manufactureYear;
	private final String brand;

	public Car(int manufactureYear, String brand) {
		this.manufactureYear = manufactureYear;
		this.brand = brand;
	}

	public int getManufactureYear() {
		return this.manufactureYear;
	}

	public String getBrand() {
		return this.brand;
	}

}
