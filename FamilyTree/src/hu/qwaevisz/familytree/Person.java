package hu.qwaevisz.familytree;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Person {

	private final int unid;
	private final String name;
	private final Gender gender;
	private final int birthYear;
	private final Integer deathYear;
	private Person mother;
	private Person father;
	private final List<Person> children;

	public Person(final int unid, final String name, final Gender gender, final int birthYear) {
		this(unid, name, gender, birthYear, null);
	}

	public Person(final int unid, final String name, final Gender gender, final int birthYear, final Integer deathYear) {
		this.unid = unid;
		this.name = name;
		this.gender = gender;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.children = new ArrayList<Person>();
	}

	public int getUnid() {
		return this.unid;
	}

	public String getName() {
		return this.name;
	}

	public Gender getGender() {
		return this.gender;
	}

	public int getBirthYear() {
		return this.birthYear;
	}

	public Integer getDeathYear() {
		return this.deathYear;
	}

	public Person getMother() {
		return this.mother;
	}

	public int getAge() {
		int age = 0;
		if (this.deathYear != null) {
			age = this.deathYear - this.birthYear;
		} else {
			final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			age = currentYear - this.birthYear;
		}
		return age;
	}

	public Person getFather() {
		return this.father;
	}

	public List<Person> getChildren() {
		return this.children;
	}

	public void setParents(final Person mother, final Person father) {
		this.mother = mother;
		this.father = father;
		mother.addChild(this);
		father.addChild(this);
	}

	public void addChild(final Person child) {
		this.children.add(child);
	}

}
