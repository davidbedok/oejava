package hu.qwaevisz.inheritance.shape;

import hu.qwaevisz.inheritance.basic.Point;

public class Shape {

	protected final Point point;

	public Shape(float x, float y) {
		this.point = new Point(x, y);
	}

	public double circumference() {
		return 0;
	}

	public double area() {
		return 0;
	}

}
