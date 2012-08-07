package hu.qwaevisz.store.criteria.spec;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.criteria.api.EnumCriterion;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;
import hu.qwaevisz.store.furniture.Bed;

public class BedMattressCriterion extends EnumCriterion<Mattress> implements FurnitureCriterion {

	public BedMattressCriterion(Mattress... values) {
		super(values);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = false;
		if (furniture instanceof Bed) {
			Bed bed = (Bed) furniture;
			valid = super.isValid(bed.getMattress());
		}
		return valid;
	}

}
