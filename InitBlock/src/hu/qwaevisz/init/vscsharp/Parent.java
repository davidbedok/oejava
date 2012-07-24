package hu.qwaevisz.init.vscsharp;

public class Parent extends Object {

	private final int foo;
	private final char bar;

	public Parent(int foo, char bar) {
		this.foo = foo;
		this.bar = bar;
	}

	public int getFoo() {
		return this.foo;
	}

	public char getBar() {
		return this.bar;
	}

	@Override
	public String toString() {
		return this.foo + " " + this.bar;
	}

}
