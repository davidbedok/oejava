package hu.qwaevisz.equals;

public class CarWithEquals extends java.lang.Object {

	private final int manufactureYear;
	private final String brand;

	public CarWithEquals(int manufactureYear, String brand) {
		this.manufactureYear = manufactureYear;
		this.brand = brand;
	}

	public int getManufactureYear() {
		return this.manufactureYear;
	}

	public String getBrand() {
		return this.brand;
	}

	@Override
	public boolean equals(Object obj) {
		// self-comparison
		if (this == obj) {
			return true;
		}

		// "null instanceof [type]" always returns false
		if (!(obj instanceof CarWithEquals)) {
			return false;
		}

		CarWithEquals that = (CarWithEquals) obj;

		if (that.getBrand().equals(this.getBrand())) {
			if (that.getManufactureYear() == this.getManufactureYear()) {
				return true;
			}
		}

		return false;
	}

	/*
	 * hashCode --> the object's memory address in hexadecimal
	 * 
	 * By definition, if two objects are equal, their hash code must also be equal. If you override the equals() method, you change the way two objects are
	 * equated and Object's implementation of hashCode() is no longer valid. Therefore, if you override the equals() method, you must also override the
	 * hashCode() method as well.
	 */

}
