package hu.qwaevisz.jpademo.model;

import hu.qwaevisz.jpademo.model.trunk.Trunkable;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the persontypes database table.
 * 
 */
@Entity
@Table(name = "persontypes")
public class PersonType implements Serializable, Trunkable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PET_ID")
	private int id;

	@Column(name = "PET_NAME")
	private String name;

	// bi-directional many-to-one association to Person
	@OneToMany(mappedBy = "personType")
	private List<Person> people;

	public PersonType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPeople() {
		return this.people;
	}

	@Override
	public String toString() {
		return this.name;
	}

}