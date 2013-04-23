package hu.qwaevisz.inheritance;

public class Triangle extends Line {

	protected final int x3;
	protected final int y3;

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		super(x1, y1, x2, y2);
		this.x3 = x3;
		this.y3 = y3;
	}

	public int getX3() {
		return this.x3;
	}

	public int getY3() {
		return this.y3;
	}

	public boolean valid() {
		boolean valid = false;
		double a = this.distance();
		double b = Line.distance(this.x, this.y, this.y3, this.x3);
		double c = Line.distance(this.x2, this.y2, this.y3, this.x3);
		if (a > b && a > c) {
			valid = b + c > a;
		} else if (b > a && b > c) {
			valid = a + c > b;
		} else if (c > a && c > b) {
			valid = a + b > c;
		}
		return valid;
	}

	public double district() {
		double a = this.distance();
		double b = Line.distance(this.x, this.y, this.y3, this.x3);
		double c = Line.distance(this.x2, this.y2, this.y3, this.x3);
		return a + b + c;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + "[" + this.x3 + ":" + this.y3 + "]";
	}

}
