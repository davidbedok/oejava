package hu.qwaevisz.store.criteria.common;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.api.CompactSizeCapable;
import hu.qwaevisz.store.criteria.api.BooleanCriterion;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;

public class CompactSizeCriterion extends BooleanCriterion implements FurnitureCriterion {

	public CompactSizeCriterion(boolean prescribedValue) {
		super(prescribedValue);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = false;
		if (furniture instanceof CompactSizeCapable) {
			CompactSizeCapable compactSizeCapable = (CompactSizeCapable) furniture;
			valid = super.isValid(compactSizeCapable.isCompactSizeMode());
		}
		return valid;
	}

}
