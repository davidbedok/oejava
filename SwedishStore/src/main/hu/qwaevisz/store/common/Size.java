package hu.qwaevisz.store.common;

public final class Size {

	public final static String	UNIT	= "cm";

	private final double		width;
	private final double		height;
	private final double		length;

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

	public double getSurface() {
		return this.width * this.length;
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

	private String formatValue(double value) {
		return String.format("%3s", Math.round(value));
	}

	@Override
	public String toString() {
		return this.formatValue(this.width) + "x" + this.formatValue(this.height) + "x" + this.formatValue(this.length) + " (" + Size.UNIT + ")";
	}

	public static Size fromString(String widthStr, String heightStr, String lengthStr) {
		double width = Double.parseDouble(widthStr);
		double height = Double.parseDouble(heightStr);
		double length = Double.parseDouble(lengthStr);
		return new Size(width, height, length);
	}

}
