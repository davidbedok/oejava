package hu.qwaevisz.store.criteria.common;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.api.BuiltInLampCapable;
import hu.qwaevisz.store.criteria.api.BooleanCriterion;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;

public class BuiltInLampCriterion extends BooleanCriterion implements FurnitureCriterion {

	public BuiltInLampCriterion(boolean prescribedValue) {
		super(prescribedValue);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = false;
		if (furniture instanceof BuiltInLampCapable) {
			BuiltInLampCapable builtInLampCapable = (BuiltInLampCapable) furniture;
			valid = super.isValid(builtInLampCapable.isBuiltInLamp());
		}
		return valid;
	}

}
