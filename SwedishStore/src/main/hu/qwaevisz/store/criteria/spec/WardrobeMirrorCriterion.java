package hu.qwaevisz.store.criteria.spec;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.criteria.api.BooleanCriterion;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;
import hu.qwaevisz.store.furniture.Wardrobe;

public class WardrobeMirrorCriterion extends BooleanCriterion implements FurnitureCriterion {

	public WardrobeMirrorCriterion(boolean prescribedValue) {
		super(prescribedValue);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = false;
		if (furniture instanceof Wardrobe) {
			Wardrobe wardrobe = (Wardrobe) furniture;
			valid = super.isValid(wardrobe.isMirror());
		}
		return valid;
	}

}
