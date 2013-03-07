package hu.qwaevisz.jpademo.model;

import hu.qwaevisz.jpademo.trunk.PersonType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Teacher")
@DiscriminatorValue(PersonType.Teacher)
public class Teacher extends Person {

	private static final long	serialVersionUID	= 1294152990160229333L;

	@Override
	public String toString() {
		return "[Teacher] " + super.toString();
	}

}
