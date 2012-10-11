package hu.qwaevisz.dto;

public class Quartet {

	private final int	a;
	private final int	b;
	private final int	c;
	private final int	d;

	public Quartet(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public int product() {
		return this.a * this.b * this.c * this.d;
	}

	@Override
	public String toString() {
		return this.a + ", " + this.b + ", " + this.c + ", " + this.d;
	}

}
