package hu.qwaevisz.storage.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Person {

	public static final String Q_INSERT = "INSERT INTO people (per_name, per_age, per_persontype_id) VALUES (?, ?, ?)";

	private final int id;
	private final String name;
	private final int age;
	private final PersonType personType;

	public Person(int id, String name, int age, PersonType personType) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.personType = personType;
	}

	public Person(String name, int age, PersonType personType) {
		this.id = -1;
		this.name = name;
		this.age = age;
		this.personType = personType;
	}

	public void setStatement(PreparedStatement statement) throws SQLException {
		statement.setString(1, this.name);
		statement.setInt(2, this.age);
		statement.setInt(3, this.personType.getId());
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public PersonType getPersonType() {
		return this.personType;
	}

	@Override
	public String toString() {
		return this.name + " (id: " + this.id + ", age: " + this.age + ", personType: " + this.personType + ")";
	}

}
