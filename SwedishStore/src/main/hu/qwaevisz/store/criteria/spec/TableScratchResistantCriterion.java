package hu.qwaevisz.store.criteria.spec;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.criteria.api.BooleanCriterion;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;
import hu.qwaevisz.store.furniture.Table;

public class TableScratchResistantCriterion extends BooleanCriterion implements FurnitureCriterion {

	public TableScratchResistantCriterion(boolean prescribedValue) {
		super(prescribedValue);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = false;
		if (furniture instanceof Table) {
			Table table = (Table) furniture;
			valid = super.isValid(table.isScratchResistant());
		}
		return valid;
	}

}
