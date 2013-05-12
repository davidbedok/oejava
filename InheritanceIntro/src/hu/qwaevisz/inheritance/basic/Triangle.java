package hu.qwaevisz.inheritance.basic;

public class Triangle extends Line {

	protected final float x3;
	protected final float y3;

	public Triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
		super(x1, y1, x2, y2);
		this.x3 = x3;
		this.y3 = y3;
	}

	public float getX3() {
		return this.x3;
	}

	public float getY3() {
		return this.y3;
	}

	public double sideA() {
		return this.distance();
	}

	public double sideB() {
		return Line.distance(this.x, this.y, this.x3, this.y3);
	}

	public double sideC() {
		return Line.distance(this.x2, this.y2, this.x3, this.y3);
	}

	public double circumference() {
		return this.sideA() + this.sideB() + this.sideC();
	}

	public boolean valid() {
		double a = this.sideA();
		double b = this.sideB();
		double c = this.sideC();
		return (a < b + c && b < a + c && c < a + b);
	}

	@Override
	public String toString() {
		return super.toString() + " and " + this.x3 + " : " + this.y3;
	}

}
