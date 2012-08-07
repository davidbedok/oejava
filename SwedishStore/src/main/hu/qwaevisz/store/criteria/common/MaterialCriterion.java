package hu.qwaevisz.store.criteria.common;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.criteria.api.EnumCriterion;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;

public class MaterialCriterion extends EnumCriterion<Material> implements FurnitureCriterion {

	public MaterialCriterion(Material... values) {
		super(values);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		return super.isValid(furniture.getMaterial());
	}

}
