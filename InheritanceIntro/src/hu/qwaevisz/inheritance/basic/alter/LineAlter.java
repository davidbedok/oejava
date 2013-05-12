package hu.qwaevisz.inheritance.basic.alter;

import hu.qwaevisz.inheritance.basic.Point;

public class LineAlter extends Object {

	protected final Point start;
	protected final Point end;

	public LineAlter(float x1, float y1, float x2, float y2) {
		this(new Point(x1, y1), new Point(x2, y2));
	}

	public LineAlter(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	public Point getStart() {
		return this.start;
	}

	public Point getEnd() {
		return this.end;
	}

	public double distance() {
		float xsd = LineAlter.sqrDifference(this.end.getX(), this.start.getX());
		float ysd = LineAlter.sqrDifference(this.end.getY(), this.start.getY());
		return Math.sqrt(xsd + ysd);
	}

	private static float sqrDifference(float a, float b) {
		float diff = a - b;
		return diff * diff;
	}

	@Override
	public String toString() {
		return this.start + " and " + this.end;
	}

}
