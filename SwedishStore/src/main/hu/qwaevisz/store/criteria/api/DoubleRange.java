package hu.qwaevisz.store.criteria.api;

public class DoubleRange {

	private Double	minValue;
	private Double	maxValue;

	public DoubleRange(Double minValue, Double maxValue) {
		if (minValue != null) {
			if ((maxValue == null) || ((maxValue != null) && (minValue <= maxValue))) {
				this.minValue = minValue;
			}
		}
		if (maxValue != null) {
			if ((minValue == null) || ((minValue != null) && (minValue <= maxValue))) {
				this.maxValue = maxValue;
			}
		}
	}

	public boolean isValid(double value) {
		boolean valid = true;
		if (this.minValue != null) {
			valid = value >= this.minValue;
		}
		if ((valid) && (this.maxValue != null)) {
			valid = value <= this.maxValue;
		}
		return valid;
	}

	// unnecessary
	public static boolean isValid(DoubleRange doubleRange, double value) {
		return (doubleRange != null && doubleRange.isValid(value)) || (doubleRange == null);
	}

	@Override
	public String toString() {
		return "Double range - value between " + this.minValue + " and " + this.maxValue;
	}

}
