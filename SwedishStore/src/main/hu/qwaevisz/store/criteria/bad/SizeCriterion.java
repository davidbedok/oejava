package hu.qwaevisz.store.criteria.bad;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.common.Size;
import hu.qwaevisz.store.criteria.api.DoubleRange;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;

// too complicated.. 
public class SizeCriterion implements FurnitureCriterion {

	private DoubleRange	widthRange;
	private DoubleRange	heightRange;
	private DoubleRange	lengthRange;

	public void addWidthCriteria(Double minValue, Double maxValue) {
		this.widthRange = new DoubleRange(minValue, maxValue);
	}

	public void addHeightCriteria(Double minValue, Double maxValue) {
		this.heightRange = new DoubleRange(minValue, maxValue);
	}

	public void addLengthCriteria(Double minValue, Double maxValue) {
		this.lengthRange = new DoubleRange(minValue, maxValue);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		Size size = furniture.getSize();
		return DoubleRange.isValid(this.widthRange, size.getWidth()) //
				&& DoubleRange.isValid(this.heightRange, size.getHeight()) //
				&& DoubleRange.isValid(this.lengthRange, size.getLength());
	}

}
