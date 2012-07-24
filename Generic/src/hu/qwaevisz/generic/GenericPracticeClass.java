package hu.qwaevisz.generic;

import hu.qwaevisz.generic.test.TestAbstract;

public class GenericPracticeClass<E extends TestAbstract> {

	private E variable;

	public GenericPracticeClass(E variable) {
		this.variable = variable;
	}

	public void print() {
		System.out.println(variable.toPrint());
	}

}
