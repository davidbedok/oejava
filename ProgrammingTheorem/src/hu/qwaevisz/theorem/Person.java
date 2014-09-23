package hu.qwaevisz.theorem;

public class Person {

	private final String name;
	private final EyeColor eyeColor;

	public Person(String name, EyeColor eyeColor) {
		super();
		this.name = name;
		this.eyeColor = eyeColor;
	}

	public String getName() {
		return this.name;
	}

	public EyeColor getEyeColor() {
		return this.eyeColor;
	}

	@Override
	public String toString() {
		return "Person [name=" + this.name + ", eyeColor=" + this.eyeColor
				+ "]";
	}

}
