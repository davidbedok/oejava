package hu.qwaevisz.inheritance.basic;

public class Line extends Point {

	protected final float x2;
	protected final float y2;

	public Line(float x1, float y1, float x2, float y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}

	public float getX2() {
		return this.x2;
	}

	public float getY2() {
		return this.y2;
	}

	public double distance() {
		float xsd = Line.sqrDifference(this.x2, this.x);
		float ysd = Line.sqrDifference(this.y2, this.y);
		return Math.sqrt(xsd + ysd);
	}

	public static double distance(float x1, float y1, float x2, float y2) {
		float xsd = Line.sqrDifference(x2, x1);
		float ysd = Line.sqrDifference(y2, y1);
		return Math.sqrt(xsd + ysd);
	}

	private static float sqrDifference(float a, float b) {
		float diff = a - b;
		return diff * diff;
	}

	@Override
	public String toString() {
		return super.toString() + " and " + this.x2 + " : " + this.y2;
	}

}
