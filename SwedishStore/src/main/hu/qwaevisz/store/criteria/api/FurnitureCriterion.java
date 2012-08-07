package hu.qwaevisz.store.criteria.api;

import hu.qwaevisz.store.api.AbstractFurniture;

public interface FurnitureCriterion {

	abstract boolean isValid(AbstractFurniture furniture);

}
