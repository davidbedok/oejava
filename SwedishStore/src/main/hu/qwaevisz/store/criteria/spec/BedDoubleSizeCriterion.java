package hu.qwaevisz.store.criteria.spec;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.criteria.api.BooleanCriterion;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;
import hu.qwaevisz.store.furniture.Bed;

public class BedDoubleSizeCriterion extends BooleanCriterion implements FurnitureCriterion {

	public BedDoubleSizeCriterion(boolean prescribedValue) {
		super(prescribedValue);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = false;
		if (furniture instanceof Bed) {
			Bed bed = (Bed) furniture;
			valid = super.isValid(bed.isDoubleSize());
		}
		return valid;
	}

}
