package hu.qwaevisz.store.criteria.bad;

import hu.qwaevisz.store.common.Size;
import hu.qwaevisz.store.criteria.api.DoubleRange;

public class SizeSearchCriteria {

	private DoubleRange	widthRange;
	private DoubleRange	heightRange;
	private DoubleRange	lengthRange;

	public void addWidthRangeCriteria(double minValue, double maxValue) {
		this.widthRange = new DoubleRange(minValue, maxValue);
	}

	public void addHeightRangeCriteria(double minValue, double maxValue) {
		this.heightRange = new DoubleRange(minValue, maxValue);
	}

	public void addLengthRangeCriteria(double minValue, double maxValue) {
		this.lengthRange = new DoubleRange(minValue, maxValue);
	}

	public boolean isValid(Size size) {
		boolean valid = true;
		if (size != null) {
			valid = (DoubleRange.isValid(this.widthRange, size.getWidth()) && DoubleRange.isValid(this.heightRange, size.getHeight()) && DoubleRange.isValid(
					this.lengthRange, size.getLength()));
		}
		return valid;
	}

	@Override
	public String toString() {
		return "SizeSearchCriteria: widthRange: " + this.widthRange + " heightRange: " + this.heightRange + " lengthRange: " + this.lengthRange;
	}

}
