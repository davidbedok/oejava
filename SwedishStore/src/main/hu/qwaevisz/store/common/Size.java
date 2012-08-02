package hu.qwaevisz.store.common;

public class Size {

	public final static String	UNIT	= "mm";

	private final double		width;			// szélesség
	private final double		height;		// magasság
	private final double		length;		// hosszúság

	public Size(double width, double height, double length) {
		this.width = width;
		this.height = height;
		this.length = length;
	}

	public double getHeight() {
		return this.height;
	}

	public double getLength() {
		return this.length;
	}

	public double getWidth() {
		return this.width;
	}

	@Override
	public String toString() {
		return this.width + "x" + this.length + "x" + this.height + "(" + Size.UNIT + ")";
	}

}
