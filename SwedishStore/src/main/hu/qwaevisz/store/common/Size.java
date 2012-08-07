package hu.qwaevisz.store.common;

public final class Size {

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
	public int hashCode() {
		return Double.valueOf(this.width).hashCode() * Double.valueOf(this.height).hashCode() * Double.valueOf(this.length).hashCode();
	}

	@Override
	public boolean equals(Object othat) {
		if (this == othat) {
			return true;
		}
		if (!(othat instanceof Size)) {
			return false;
		}
		Size that = (Size) othat;
		if (this.width == that.width && this.height == that.height && this.length == that.length) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return this.width + " x " + this.height + " x " + this.length + " (" + Size.UNIT + ")";
	}

}
