package hu.qwaevisz.inheritance.shape;

import hu.qwaevisz.inheritance.basic.Point;

public class Rectangle extends Shape {

	private final Point bottomRightCorner;

	public Rectangle(float topLeftCornerX, float topLeftY, float bottomRightX,
			float bottomRightY) {
		super(topLeftCornerX, topLeftY);
		this.bottomRightCorner = new Point(bottomRightX, bottomRightY);
	}

	public double sideA() {
		return Math.abs(this.point.getX() - this.bottomRightCorner.getX());
	}

	public double sideB() {
		return Math.abs(this.point.getY() - this.bottomRightCorner.getY());
	}

	@Override
	public double circumference() {
		return 2 * this.sideA() + 2 * this.sideB();
	}

	@Override
	public double area() {
		return this.sideA() * this.sideB();
	}

	@Override
	public String toString() {
		return "Rectangle (topLeft: " + this.point + ", bottomRight: "
				+ this.bottomRightCorner + ")";
	}

}
