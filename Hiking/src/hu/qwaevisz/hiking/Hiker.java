package hu.qwaevisz.hiking;

public class Hiker {

	private final String name;
	private final int birthYear;

	public Hiker(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}

	public String getName() {
		return this.name;
	}

	public int getBirthYear() {
		return this.birthYear;
	}

	@Override
	public String toString() {
		return this.name + " (year of birth: " + this.birthYear + ")";
	}

}
