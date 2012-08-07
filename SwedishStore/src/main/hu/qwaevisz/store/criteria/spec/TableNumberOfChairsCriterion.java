package hu.qwaevisz.store.criteria.spec;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;
import hu.qwaevisz.store.criteria.api.IntegerRange;
import hu.qwaevisz.store.furniture.Table;

public class TableNumberOfChairsCriterion extends IntegerRange implements FurnitureCriterion {

	public TableNumberOfChairsCriterion(Integer minValue, Integer maxValue) {
		super(minValue, maxValue);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = false;
		if (furniture instanceof Table) {
			Table table = (Table) furniture;
			valid = super.isValid(table.getNumberOfChairs());
		}
		return valid;
	}

}
