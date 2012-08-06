package hu.qwaevisz.store.criteria;

public class DoubleRange {

	private final double minValue;
	private final double maxValue;

	public DoubleRange(double minValue, double maxValue) {
		this.minValue = Math.min(minValue, maxValue);
		this.maxValue = Math.max(minValue, maxValue);
	}

	public boolean isValid(double value) {
		return (value >= this.minValue && value <= this.maxValue);
	}

	public static boolean isValid(DoubleRange doubleRange, double value) {
		return (doubleRange != null && doubleRange.isValid(value))
				|| (doubleRange == null);
	}

	@Override
	public String toString() {
		return "Double range - value between " + this.minValue + " and "
				+ this.maxValue;
	}

}
