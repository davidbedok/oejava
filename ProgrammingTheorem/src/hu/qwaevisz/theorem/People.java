package hu.qwaevisz.theorem;

import java.util.Arrays;

public class People {

	private static final int NUMBER_OF_PEOPLE = 10;
	private final Person[] items;
	private int index;

	public People() {
		this.items = new Person[People.NUMBER_OF_PEOPLE];
	}

	public Person getPerson(EyeColor eyeColor) {
		Person ret = null;
		for (final Person person : this.items) {
			if (person.getEyeColor() == eyeColor) {
				ret = person;
				break;
			}
		}
		return ret;
	}

	public void add(String name, EyeColor eyeColor) {
		this.items[this.index++] = new Person(name, eyeColor);
	}

	@Override
	public String toString() {
		return Arrays.toString(this.items);
	}

}
