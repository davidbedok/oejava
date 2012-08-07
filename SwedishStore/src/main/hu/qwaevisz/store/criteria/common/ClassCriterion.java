package hu.qwaevisz.store.criteria.common;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClassCriterion implements FurnitureCriterion {

	private Set<Class<?>>	clazzes;

	public ClassCriterion(Class<?>... clazzes) {
		if (clazzes.length > 0) {
			this.clazzes = new HashSet<Class<?>>(Arrays.asList(clazzes));
		}
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = true;
		if (this.clazzes != null) {
			for (Class<?> clazz : this.clazzes) {
				// order is important !
				if (!clazz.isAssignableFrom(furniture.getClass())) {
					valid = false;
					break;
				}
			}
		}
		return valid;
	}

}
