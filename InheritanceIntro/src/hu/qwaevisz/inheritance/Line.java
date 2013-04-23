package hu.qwaevisz.inheritance;

public class Line extends Point {

	protected final int x2;
	protected final int y2;

	public Line(int x1, int y1, int x2, int y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX2() {
		return this.x2;
	}

	public int getY2() {
		return this.y2;
	}

	public double distance() {
		int xsd = Line.sqrDifference(this.x2, this.x);
		int ysd = Line.sqrDifference(this.y2, this.y);
		return Math.sqrt(xsd + ysd);
	}

	protected static double distance(int x1, int y1, int x2, int y2) {
		int xsd = Line.sqrDifference(x2, x1);
		int ysd = Line.sqrDifference(y2, y1);
		return Math.sqrt(xsd + ysd);
	}

	private static int sqrDifference(int a, int b) {
		int diff = a - b;
		return diff * diff;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + "[" + this.x2 + ":" + this.y2 + "]";
	}

}
