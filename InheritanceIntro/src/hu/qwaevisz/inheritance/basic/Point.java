package hu.qwaevisz.inheritance.basic;

public class Point extends Object {

	protected final float x;
	protected final float y;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return this.x + " : " + this.y;
	}

}
