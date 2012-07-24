package hu.qwaevisz.equals;

public class CarWithHashCode {

	private final int manufactureYear;
	private final String brand;

	public CarWithHashCode(int manufactureYear, String brand) {
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
	public int hashCode() {
		// bad algorithm...
		return this.manufactureYear;
	}

	@Override
	public boolean equals(Object obj) {
		// self-comparison
		if (this == obj) {
			return true;
		}

		// "null instanceof [type]" always returns false
		if (!(obj instanceof CarWithHashCode)) {
			return false;
		}

		CarWithHashCode that = (CarWithHashCode) obj;

		// no use in this way... hashCode() and equals() must be independent to
		// each other
		if (that.hashCode() == this.hashCode()) {
			return true;
		}

		return false;
	}

}
