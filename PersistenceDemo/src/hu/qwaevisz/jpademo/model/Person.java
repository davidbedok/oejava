package hu.qwaevisz.jpademo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the persons database table.
 * 
 */
@Entity
@Table(name = "people")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PER_ID")
	private int id;

	@Column(name = "PER_AGE")
	private int age;

	@Column(name = "PER_NAME")
	private String name;

	// bi-directional many-to-one association to Persontype
	@ManyToOne
	@JoinColumn(name = "PER_PERSONTYPE_ID")
	private PersonType personType;

	public Person() {
	}

	public Person(String name, int age, PersonType personType) {
		this.name = name;
		this.age = age;
		this.personType = personType;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonType getPersontype() {
		return this.personType;
	}

	public void setPersontype(PersonType persontype) {
		this.personType = persontype;
	}

	@Override
	public String toString() {
		StringBuilder person = new StringBuilder(50);
		person.append(this.name).append(" [");
		person.append("id: ").append(this.id);
		person.append(" age: ").append(this.age);
		person.append(" personType: ").append(this.personType);
		person.append("]");
		return person.toString();
	}

}