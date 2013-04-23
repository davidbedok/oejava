package hu.qwaevisz.inheritance;

public class Point extends Object {

	protected final int x;
	protected final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "[" + this.x + ":" + this.y + "]";
	}

}
