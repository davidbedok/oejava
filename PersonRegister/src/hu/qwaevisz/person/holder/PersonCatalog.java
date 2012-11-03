package hu.qwaevisz.person.holder;

import java.util.ArrayList;
import java.util.List;

public class PersonCatalog {

	private final List<Person> people;

	public void addPerson(String name, String password, String email) {
		this.people.add(new Person(name, password, email));
	}

	// danger..
	public List<Person> getPeople() {
		return this.people;
	}

	private static PersonCatalog instance = null;

	protected PersonCatalog() {
		this.people = new ArrayList<Person>();
	}

	public static PersonCatalog getInstance() {
		if (PersonCatalog.instance == null) {
			synchronized (PersonCatalog.class) {
				if (PersonCatalog.instance == null) {
					PersonCatalog.instance = new PersonCatalog();
				}
			}
		}
		return PersonCatalog.instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
