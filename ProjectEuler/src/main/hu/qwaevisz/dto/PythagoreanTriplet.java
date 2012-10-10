package hu.qwaevisz.dto;

public class PythagoreanTriplet {

	private final int	a;
	private final int	b;
	private final int	c;

	public PythagoreanTriplet(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int sum() {
		return this.a + this.b + this.c;
	}

	public int product() {
		return this.a * this.b * this.c;
	}

	public int getA() {
		return this.a;
	}

	public int getB() {
		return this.b;
	}

	public int getC() {
		return this.c;
	}

	@Override
	public String toString() {
		return this.a + " - " + this.b + " - " + this.c;
	}

}