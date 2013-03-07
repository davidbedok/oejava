package hu.qwaevisz.jpademo.model;

import hu.qwaevisz.jpademo.trunk.PersonType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Student")
@DiscriminatorValue(PersonType.Student)
public class Student extends Person {

	private static final long	serialVersionUID	= 4268286664049652850L;

	private String				neptunCode;

	public String getNeptunCode() {
		return this.neptunCode;
	}

	public void setNeptunCode(String neptunCode) {
		this.neptunCode = neptunCode;
	}

	@Override
	public String toString() {
		return "[Student] " + super.toString();
	}

}
