package hu.qwaevisz.store.criteria.common;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.criteria.api.DoubleRange;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;

public class SizeWidthCriterion extends DoubleRange implements FurnitureCriterion {

	public SizeWidthCriterion(Double minValue, Double maxValue) {
		super(minValue, maxValue);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		return super.isValid(furniture.getSize().getWidth());
	}

}
