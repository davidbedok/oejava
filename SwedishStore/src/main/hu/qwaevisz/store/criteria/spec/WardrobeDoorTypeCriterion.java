package hu.qwaevisz.store.criteria.spec;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.common.DoorType;
import hu.qwaevisz.store.criteria.api.EnumCriterion;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;
import hu.qwaevisz.store.furniture.Wardrobe;

public class WardrobeDoorTypeCriterion extends EnumCriterion<DoorType> implements FurnitureCriterion {

	public WardrobeDoorTypeCriterion(DoorType... values) {
		super(values);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = false;
		if (furniture instanceof Wardrobe) {
			Wardrobe wardrobe = (Wardrobe) furniture;
			valid = super.isValid(wardrobe.getTypeOfDoor());
		}
		return valid;
	}

}
