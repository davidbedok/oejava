package hu.qwaevisz.store.criteria.spec;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;
import hu.qwaevisz.store.criteria.api.IntegerRange;
import hu.qwaevisz.store.furniture.Wardrobe;

public class WardrobeNumberOfShelvesCriterion extends IntegerRange implements FurnitureCriterion {

	public WardrobeNumberOfShelvesCriterion(Integer minValue, Integer maxValue) {
		super(minValue, maxValue);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = false;
		if (furniture instanceof Wardrobe) {
			Wardrobe wardrobe = (Wardrobe) furniture;
			valid = super.isValid(wardrobe.getNumberOfShelves());
		}
		return valid;
	}

}
