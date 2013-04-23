package hu.qwaevisz.inheritance;

public class LineAlter extends Object {

	protected final Point start;
	protected final Point end;

	public LineAlter(int x1, int y1, int x2, int y2) {
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
		int xsd = LineAlter.sqrDifference(this.end.getX(), this.start.getX());
		int ysd = LineAlter.sqrDifference(this.end.getY(), this.start.getY());
		return Math.sqrt(xsd + ysd);
	}

	private static int sqrDifference(int a, int b) {
		int diff = a - b;
		return diff * diff;
	}

	@Override
	public String toString() {
		return this.start + " - " + this.end;
	}

}
