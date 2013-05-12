package hu.qwaevisz.inheritance.shape;

public class Circle extends Shape {

	private final float radius;

	public Circle(float radius, float origoX, float origoY) {
		super(origoX, origoY);
		this.radius = radius;
	}

	public double diameter() {
		return this.radius * 2;
	}

	@Override
	public double circumference() {
		return this.diameter() * Math.PI;
	}

	@Override
	public double area() {
		return this.radius * this.radius * Math.PI;
	}

	@Override
	public String toString() {
		return "Circle (origo: " + this.point + ", radius: " + this.radius
				+ ")";
	}

}
