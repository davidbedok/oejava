package hu.qwaevisz.books;

import hu.qwaevisz.common.SellAble;

public abstract class Book extends java.lang.Object implements SellAble {

	protected String name;

	public Book(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Book Name: " + this.name;
	}

	public abstract void toPrint();

}
