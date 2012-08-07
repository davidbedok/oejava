package hu.qwaevisz.store.criteria.api;

public class IntegerRange {

	private Integer	minValue;
	private Integer	maxValue;

	public IntegerRange(Integer minValue, Integer maxValue) {
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

	public boolean isValid(int value) {
		boolean valid = true;
		if (this.minValue != null) {
			valid = value >= this.minValue;
		}
		if ((valid) && (this.maxValue != null)) {
			valid = value <= this.maxValue;
		}
		return valid;
	}

	@Override
	public String toString() {
		return "Integer range - value between " + this.minValue + " and " + this.maxValue;
	}

}
